package com.example.mentoring_project.security;

import com.example.mentoring_project.domain.MemberRole;
import com.example.mentoring_project.domain.SMemberVO;
import com.example.mentoring_project.dto.MemberSecurityDTO;
import com.example.mentoring_project.mapper.SMemberMapper;
import com.example.mentoring_project.service.SMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final SMemberService sMemberService;

    private final SMemberMapper sMemberMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("userRequest....");
        log.info(userRequest);

        log.info("oauth2 user...");

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();

        log.info("NAME: " + clientName);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();

        String mid = null;
        switch (clientName) {
            case "kakao":
                mid = getKakaoEmail(paramMap);
                break;
        }

        log.info("================");
        log.info(mid);
        log.info("================");

//        paramMap.forEach((k, v) -> {
//            log.info("--------");
//            log.info(k + ":" + v);
//        });


        return generateDTO(mid, paramMap);
    }


    private String getKakaoEmail(Map<String, Object> paramMap) {
        log.info("KAKAO.....................");

        Object value = paramMap.get("kakao_account");
        log.info(value);

        LinkedHashMap accountMap = (LinkedHashMap) value;
        String email = (String) accountMap.get("email");

        log.info("email...." + email);
        return email;
    }

    private MemberSecurityDTO generateDTO(String email, Map<String, Object> params) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        SMemberVO member = sMemberService.getMemberId(email);
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        log.info(member);
        // 데이터베이스에 해당 이메일의 사용자가 없다면
        if(member == null) {
            log.info("social member");
            // 회원 추가 -- mid는 이메일주소 / 패스워드는 1111
//            Set<MemberRole> role = MemberRole.values()[0];
            SMemberVO sMemberVO = SMemberVO.builder()
                    .mid(email)
                    .mpw(passwordEncoder.encode("1111"))
//                    .email(email)
                    .social(true)
                    .build();
            sMemberMapper.addMember(sMemberVO);


            MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
//                    email, "1111", email, false, true
                    sMemberVO.getMid(), "1111", false, sMemberVO.isSocial(), sMemberVO.getType(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
            );
            memberSecurityDTO.setProps(params);


            return memberSecurityDTO;
        }
        else {
            log.info("social login");
            Set<MemberRole> roles = member.getRoleSet();
            Set<MemberRole> newRoles = new HashSet<>();
            for(int i=0; i<roles.size(); i++){
                MemberRole test = MemberRole.values()[i];
                newRoles.add(test);
            }
            member.setRoleSet(newRoles);
            MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
                    member.getMid(),
                    member.getMpw(),
//                    member.getEmail(),
                    member.isDel(),
                    member.isSocial(),
                    member.getType(),
                    member.getRoleSet().stream()
                            .map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
                            .collect(Collectors.toList())
            );
            return memberSecurityDTO;
        }
    }
}
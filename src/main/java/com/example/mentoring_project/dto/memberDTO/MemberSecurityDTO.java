package com.example.mentoring_project.dto.memberDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User implements OAuth2User {
    // 스프링 시큐리티에서 제공하는 User 객체를 상속받음
    // 이 DTO에서 로그인할때 사용 하는 DTO
    // 로그인할 때 DB의 값과 입력받은 값을 매칭 시켜주는 DTO

    private String mid;
    private String mpw;
    private boolean del;
    private boolean social;
    private String type;

    private String nickname;

    private Map<String, Object> props;


    // MemberSecurityDTO 가 생성될 때 username, password, authorities를 받아와서
    // 상속받은 User의 메소드 ( super(username, password, authorities) )를 사용해 설정해 줌
    public MemberSecurityDTO(String username, String password, boolean del, boolean social, String type, String nickname,
                             Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        log.info(authorities);
        this.mid = username;
        this.mpw = password;
        this.del = del;
        this.social = social;
        this.type = type;
        this.nickname = nickname;
        log.info("@@@");
        log.info(password);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.getProps();
    }

    @Override
    public String getName() {
        return this.mid;
    }


}

package com.example.mentoring_project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    public static Pageable of; // 페이지 이동 정보 - Model로 자동 전달
    @Builder.Default
    @Min(value=1)
    @Positive // 양수
    private int page=1;
    // Min, Max로 외부 조작 대비
    @Builder.Default
    @Min(value = 10) // 페이지당 게시물 최소값
    @Max(value = 100)
    @Positive
    private int size = 10; // sql limit 뒤 숫자. 페이지당 게시물 개수!

    private String link;

    private String type; // 검색의 종류 s,c
    // 검색 기능을 위한 추가
    private String[] types; //
    private String keyword; // 제목,작성자 검색에 사용하는 문자열



    public int getSkip() { // limit에서 사용하는 건너뛰기skip의 수
        return (page - 1) * size;
    }

    public String[] getTypes() { // 검색
        if(this.type==null || type.isEmpty()) {
            return null;
        }
        return this.type.split("");
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
//        if (link == null) {
//
//        }

        if (this.types != null && this.types.length > 0) {
            for (int i = 0; i < this.types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }
        if (this.keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        link = builder.toString();
        return link;
    }


    // 화면에 검색조건 표시
    public boolean checkType(String type) {
        if (this.types == null || this.types.length == 0) {
            return false;
        } else {
            return Arrays.asList(this.types).contains(type);
        }
    }
}

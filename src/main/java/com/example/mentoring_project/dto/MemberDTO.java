package com.example.mentoring_project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long memberNo;
    private String id;
    private String name;
    private String region;
    private String type;
    private int age;
    private String nickname;
}

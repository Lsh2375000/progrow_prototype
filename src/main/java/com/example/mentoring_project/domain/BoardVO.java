package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
@Entity
public class BoardVO extends BaseEntity{

    public static BoardVO BoardVOBuilder;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String id;
    private Integer hit;

    @Column(length = 2000, nullable = false) //컬럼의 길이와 null 허용 여부
    private String content;

    @Column(length = 500, nullable = false)
    private String writer;

    @Column(length = 500, nullable = false)
    private String title;

    public void change(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @OneToMany(mappedBy = "boardVO",
    cascade = {CascadeType.ALL},
    fetch = FetchType.LAZY,
    orphanRemoval = true) //BoardImage의 board변수
    @Builder.Default
    private Set<BoardImageVO> imageVOSet = new HashSet<>();

    public void addImage(String uuid, String fileName){
        BoardImageVO boardImageVO = BoardImageVO.builder()
                .uuid(uuid)
                .fileName(fileName)
                .boardVO(this)
                .ord(imageVOSet.size())
                .build();
        imageVOSet.add(boardImageVO);
    }

    public void clearImages(){
        imageVOSet.forEach(boardImageVO -> boardImageVO.changeBoard(null));
        this.imageVOSet.clear();
    }

}

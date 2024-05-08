package com.homepage.likelion.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
@Builder
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "POSTS_ID")
    private Long id; // 글 고유 아이디

    @Column(name = "POSTS_TITLE")
    private String title; // 글 제목

    @Column(name = "POSTS_CONTENT")
    private String content; // 글 내용

    @Column(name = "POSTED_USER_NAME")
    private String postedUserName; // 작성자 이름

    @Column(name = "POSTS_PASSWORD")
    private String password; // 비밀번호

//    @Enumerated(EnumType.STRING)
//    @Column(name = "POST_STATUS")
//    private PostStatus status; // 게시글 상태
//
//    public Post(String title, String content, String password, String postedUserName, PostStatus status) {
//        this.title = title;
//        this.content = content;
//        this.password = password;
//        this.postedUserName = postedUserName;
//        this.status = status;
//    }
//
//    // 게시글 내용 수정 메소드
//    public void changeContent(String content) {
//        this.content = content;
//    }
//
//    // 게시글 제목 수정 메소드
//    public void changeTitle(String title) {
//        this.title = title;
//    }
//
//    // 상태 변경 메소드
//    public void changeStatus(PostStatus status) {
//        this.status = status;
//    }
//
//    // 게시글 작성자 수정 메소드
//    public void changeUserName(String postedUserName) {
//        this.postedUserName = postedUserName;
//    }
}

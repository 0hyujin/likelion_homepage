package com.homepage.likelion.posts.dto;

import com.homepage.likelion.domain.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// 게시글 조회 응답 DTO
public class PostListDto {

    @Getter @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class PostResponse {
        private Long postId; // 게시글의 고유 아이디
        private String postedUserName; // 작성자 이름
        private String title; // 게시글 제목
        private String content; // 게시글 내용
        private LocalDateTime updatedAt; // 최종 수정 날짜
    }

    // 게시글 조회 : List<Post> posts
    @Getter @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SearchPostsRes {
        private List<PostListDto.PostResponse> posts;

        public SearchPostsRes(List<PostListDto.PostResponse> posts) {
            this.posts = posts;
        }


        // Post 엔티티 리스트를 받아서 SearchPostsRes 인스턴스 생성
        public static PostListDto.SearchPostsRes fromEntityList(List<Post> postList) {
            // postList에서 필요한 요소들 꺼내서 반환 타입 생성
            List<PostListDto.PostResponse> postResponses = postList.stream()
                    .map(post -> new PostListDto.PostResponse(
                            post.getId(), // 게시글 고유 식별 아이디
                            post.getPostedUserName(), // 작성자 이름
                            post.getTitle(), // 게시글 제목
                            post.getContent(), // 게시글 내용
                            post.getUpdatedAt())) // 최종 수정 시간
                    .collect(Collectors.toList());
            return new PostListDto.SearchPostsRes(postResponses);
        }
    }
}

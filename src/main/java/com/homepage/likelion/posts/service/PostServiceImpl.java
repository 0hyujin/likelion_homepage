package com.homepage.likelion.posts.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    // 게시글 작성
    @Override
    public ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req) {
        // 방법 1. toEntity() 메서드를 호출하여 엔티티 객체를 생성
        Post post = req.toEntity();

        // 방법 2. builder
//        Post post = Post.builder()
//                .title(req.getTitle())
//                .content(req.getContent())
//                .password(req.getPassword())
//                .postedUserName(req.getPostedUserName())
//                .build();

        Post savedPost = postRepository.save(post);

        // 생성된 게시글의 정보를 포함한 응답 반환
        PostCreateDto.CreatePost createdPostResponse = new PostCreateDto.CreatePost(savedPost.getId(), savedPost.getUpdatedAt());
        CustomApiResponse<PostCreateDto.CreatePost> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), createdPostResponse,"게시글이 작성되었습니다.");
        return ResponseEntity.ok(res);
    }

    // 게시글 수정
    @Override
    public ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req) {
        // 게시물 검색
        Optional<Post> optionalPost = postRepository.findById(postId);

        // 게시물 업데이트
        Post post = optionalPost.get();
        post.changeTitle(req.getTitle());
        post.changeContent(req.getContent());
        post.changeUserName(req.getPostedUserName());
        postRepository.flush(); // 변경 사항을 데이터베이스에 즉시 적용

        // 수정된 게시글 정보 응답
        PostUpdateDto.UpdatePost data = new PostUpdateDto.UpdatePost(post.getUpdatedAt());
        CustomApiResponse<PostUpdateDto.UpdatePost> res = CustomApiResponse.createSuccess(HttpStatus.OK.value(), data, "게시글이 수정되었습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}

package com.homepage.likelion.posts.controller;

import com.homepage.likelion.posts.dto.PostCreateDto;
import com.homepage.likelion.posts.dto.PostUpdateDto;
import com.homepage.likelion.posts.service.PostService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성
    // 게시글 정보를 받아야 한다. dto 필요
    // dto를 받기 위해선 @RequestBody 필요
    @PostMapping
    public ResponseEntity<CustomApiResponse<?>> createPost(
            @Valid @RequestBody PostCreateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = postService.createPost(req);
        return result;
    }

    // 게시글 수정
    @PutMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> modifyPost(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = postService.modifyPost(postId, req);
        return result;
    }

    // 전체 게시글 조회
    @GetMapping("/all")
    public ResponseEntity<CustomApiResponse<?>> getAllPost() {
        ResponseEntity<CustomApiResponse<?>> result = postService.getAllPost();
        return result;
    }
}

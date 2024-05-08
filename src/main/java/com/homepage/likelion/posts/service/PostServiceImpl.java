package com.homepage.likelion.posts.service;

import com.homepage.likelion.posts.repository.PostRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    // 게시글 작성

}

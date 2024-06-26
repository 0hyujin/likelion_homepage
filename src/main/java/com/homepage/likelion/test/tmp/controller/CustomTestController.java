package com.homepage.likelion.test.tmp.controller;

import com.homepage.likelion.test.tmp.dto.SimpleDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {

    @PostMapping("/simple")
    public ResponseEntity<CustomApiResponse<?>> simple(){

        // 1. 응답 Body 구성
        // 단축티 ctrl Alt V
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원 가입에 성공했습니다.");

        // 2. 응답 Body를 ResponseEntity에 넣기
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping("/jsonData")
    public ResponseEntity<CustomApiResponse<?>> jsonData(){

        // userId : example
        // email : example@naver.com

        // dto 클래스  방법 1 : new
//        SimpleDto dto = new SimpleDto("example", "example@naver.cpm");

        // 방법 2 : builder
        SimpleDto dto = SimpleDto.builder()
                .userId("example")
                .email("example@naver.com")
                .build();

        CustomApiResponse<Object> responseBody = CustomApiResponse.createSuccess(HttpStatus.OK.value(), dto, "회원 조회에 성공했습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}

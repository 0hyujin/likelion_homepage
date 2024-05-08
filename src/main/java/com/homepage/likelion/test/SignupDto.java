package com.homepage.likelion.test;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {


    @NotEmpty(message = "userID는 필수값입니다.")
    private String userId;
    private String email;
    private String password;
}

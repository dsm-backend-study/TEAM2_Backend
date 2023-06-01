package com.example.springtodo.domain.User.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequest {

        private String userId;

        private String userPassword;
}

package com.example.springtodo.domain.User.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserCreateRequest {
    private String userId;

    private String userPassword;

    private String userName;

    private String userEmail;

}

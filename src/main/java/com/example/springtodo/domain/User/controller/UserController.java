package com.example.springtodo.domain.User.controller;

import com.example.springtodo.domain.User.controller.dto.request.UserSignRequest;
import com.example.springtodo.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public void userCreate(
            @RequestBody UserSignRequest request
            ) {
        userService.createUser(request);
    }
}

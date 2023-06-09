package com.example.springtodo.domain.User.controller;

import com.example.springtodo.domain.User.controller.dto.request.UserSignRequest;
import com.example.springtodo.domain.User.controller.dto.request.UserUpdateRequest;
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
            @RequestBody UserSignRequest userSignRequest
            ) {
        userService.createUser(userSignRequest);
    }

    @PutMapping("/modify/{userId}")
<<<<<<< HEAD
    public void userUpdate(
            @RequestBody UserUpdateRequest userUpdateRequest
            ) {
        userService.updateUser(userUpdateRequest);
=======
    public void updateUser(
            @RequestBody UserUpdateRequest userUpdateRequest
            ) {
        userService.update(userUpdateRequest);
>>>>>>> todo
    }

    @DeleteMapping("remove/{userId}")
    public void userRemove(
            @PathVariable Long userId
    ) {
<<<<<<< HEAD
        userService.deleteUser(userId);
=======
        userService.delete(userId);
>>>>>>> todo
    }
}


package com.example.springtodo.domain.User.service;

import com.example.springtodo.domain.User.controller.dto.request.UserLoginRequest;
import com.example.springtodo.domain.User.controller.dto.request.UserSignRequest;
import com.example.springtodo.domain.User.controller.dto.request.UserUpdateRequest;
import com.example.springtodo.domain.User.entity.User;
import com.example.springtodo.domain.User.exception.AlreadyExistEmailException;
import com.example.springtodo.domain.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(
            UserSignRequest userCreateRequest
    ) {
        String userId = userCreateRequest.getUserId();
        Optional<User>user = userRepository.findByUserId(userId);

        if(user.isEmpty()){
            userRepository.save(
                    User.builder()
                            .userId(userCreateRequest.getUserId())
                            .userName(userCreateRequest.getUserName())
                            .userPassword(userCreateRequest.getUserPassword())
                            .userEmail(userCreateRequest.getUserEmail())
                            .build()
            );
        }
        else
            throw new AlreadyExistEmailException();
    }

    @Transactional
    public String loginUser(
            UserLoginRequest userLoginRequest
    ) {
        User user = userRepository.findByUserId(userLoginRequest.getUserId())
                .orElseThrow();
        if(userLoginRequest.getUserId() == user.getUserId() && userLoginRequest.getUserPassword() == user.getUserPassword())
            return "login succeeded";

        else
            return "password is not matched";

    }
}

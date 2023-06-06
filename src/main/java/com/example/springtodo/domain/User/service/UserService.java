package com.example.springtodo.domain.User.service;

import com.example.springtodo.domain.User.controller.dto.request.UserSignRequest;
import com.example.springtodo.domain.User.entity.User;
import com.example.springtodo.domain.User.repository.UserRepository;
import com.example.springtodo.domain.User.service.exception.AlreadyExistEmailException;
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
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isEmpty())
            userRepository.save(
                    User.builder()
                            .userId(userCreateRequest.getUserId())
                            .userName(userCreateRequest.getUserName())
                            .userPassword(userCreateRequest.getUserPassword())
                            .build()
            );

        else
            throw new AlreadyExistEmailException();
    }
}

package com.example.springtodo.domain.User.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String userId;

        private String userPassword;

        private String userName;

        private String userEmail;

        @Builder
        public User(String userId, String userName, String userPassword, String userEmail){
                this.userId = userId;
                this.userName = userName;
                this.userPassword = userPassword;
                this.userEmail = userEmail;
        }
}


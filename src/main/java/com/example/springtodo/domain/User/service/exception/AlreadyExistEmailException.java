package com.example.springtodo.domain.User.service.exception;
public class AlreadyExistEmailException extends RuntimeException{
    private static final String MESSAGE = "이미 등록된 아이디 입니다";

    public  AlreadyExistEmailException(){
        super(MESSAGE);
    }
}

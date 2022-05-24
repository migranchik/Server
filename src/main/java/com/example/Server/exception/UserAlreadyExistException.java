package com.example.Server.exception;

public class UserAlreadyExistException extends  Exception{

    public UserAlreadyExistException(String message) {
        super(message);
    }

}

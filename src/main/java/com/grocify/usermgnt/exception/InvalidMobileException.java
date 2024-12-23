package com.grocify.usermgnt.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidMobileException extends RuntimeException{
    private String message;
}

package com.grocify.usermgnt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidPasswordException extends RuntimeException {
    private String message;
}

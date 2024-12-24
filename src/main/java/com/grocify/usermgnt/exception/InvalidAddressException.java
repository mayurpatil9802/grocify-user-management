package com.grocify.usermgnt.exception;

public class InvalidAddressException extends RuntimeException {
    public InvalidAddressException(String message) {
        super(message);
    }
}

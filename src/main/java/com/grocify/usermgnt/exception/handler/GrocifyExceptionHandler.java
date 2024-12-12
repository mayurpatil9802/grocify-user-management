package com.grocify.usermgnt.exception.handler;

import com.grocify.usermgnt.exception.InvalidCredentialsException;
import com.grocify.usermgnt.exception.InvalidRequestException;
import com.grocify.usermgnt.exception.UserNotFoundException;
import com.grocify.usermgnt.model.response.GrocifyErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GrocifyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GrocifyErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.NOT_FOUND.value()).build(), HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }


    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<GrocifyErrorResponse> handleUserInvalidPassword(InvalidCredentialsException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.UNAUTHORIZED.value()).build(), HttpStatusCode.valueOf(HttpStatus.UNAUTHORIZED.value()));
    }
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<GrocifyErrorResponse> handleUserbankPassword(InvalidRequestException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.NOT_FOUND.value()).build(), HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }

}

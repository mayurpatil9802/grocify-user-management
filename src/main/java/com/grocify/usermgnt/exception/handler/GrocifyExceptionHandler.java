package com.grocify.usermgnt.exception.handler;



import com.grocify.usermgnt.exception.*;
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
    public ResponseEntity<GrocifyErrorResponse> handleInvalidRequestException(InvalidRequestException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }


    @ExceptionHandler(InvalidFirstNameException.class)
    public ResponseEntity<GrocifyErrorResponse> handleInvalidFirstNameException(InvalidFirstNameException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
    @ExceptionHandler(InvalidLastNameException.class)
    public ResponseEntity<GrocifyErrorResponse> handleInvalidListNameException(InvalidLastNameException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
    @ExceptionHandler(InvalidAddressException.class)
    public ResponseEntity<GrocifyErrorResponse> invalidAddressException(InvalidAddressException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<GrocifyErrorResponse> invalidPasswordException(InvalidAddressException exception) {
        return new ResponseEntity<>(GrocifyErrorResponse.builder().message(exception.getMessage()).errorCode(HttpStatus.BAD_REQUEST.value()).build(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

}

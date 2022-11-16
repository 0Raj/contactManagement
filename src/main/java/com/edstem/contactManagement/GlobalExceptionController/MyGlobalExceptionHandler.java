package com.edstem.contactManagement.GlobalExceptionController;

import com.edstem.contactManagement.userDefinedException.ContactAlreadyPresent;
import com.edstem.contactManagement.userDefinedException.ContactNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(ContactNotFound.class)
    public ResponseEntity<ExceptionMsg> contactNotFound(ContactNotFound contactNotFound, WebRequest request){
        ExceptionMsg exceptionMsg = new ExceptionMsg( contactNotFound.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.toString(), LocalDate.now());
        return new ResponseEntity<>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ContactAlreadyPresent.class)
    public ResponseEntity<ExceptionMsg> contactAlreadyPresent(ContactAlreadyPresent contactAlreadyPresent, WebRequest request){
        ExceptionMsg exceptionMsg = new ExceptionMsg( contactAlreadyPresent.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.toString(), LocalDate.now());
        return new ResponseEntity<>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMsg> myMANVExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {

        ExceptionMsg exceptionMsg = new ExceptionMsg( "Validation Error", HttpStatus.METHOD_NOT_ALLOWED.toString(), LocalDate.now());
        return new ResponseEntity<>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMsg> generalException(Exception exception, WebRequest request){
        ExceptionMsg exceptionMsg = new ExceptionMsg( exception.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.toString(), LocalDate.now());

        return  new ResponseEntity<>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }

}

package com.mladen.studies.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.persistence.EntityNotFoundException;;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = InternalAuthenticationServiceException.class)
    public ResponseEntity<Object> exceptionUn(InternalAuthenticationServiceException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> exceptionEntityNotFound(EntityNotFoundException exception) {
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Object> exceptionUserNotFound(UsernameNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        return new ResponseEntity<>("Fatal error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

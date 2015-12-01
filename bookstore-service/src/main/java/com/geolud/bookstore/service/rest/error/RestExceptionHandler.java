package com.geolud.bookstore.service.rest.error;

import com.geolud.bookstore.service.books.service.exception.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity<RestError> handleAnyException(Exception e) {
        return createError(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BookNotFoundException.class})
    @ResponseBody
    public ResponseEntity<RestError> handleBookNotFoundException(BookNotFoundException e) {
        return createError(e, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<RestError> createError(Throwable t, HttpStatus status){
        log.error("rest error ", t);
        return new ResponseEntity<>(new RestError(t), new HttpHeaders(), status);
    }
}

package br.com.postzy.www.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpNoSourchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ApiErrorMessage> handleExceptionNoSourchException(HttpNoSourchException e){
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND,
            errors,
            e.getMessage()
        );
        return new ResponseEntity<>(apiErrorMessage, null, apiErrorMessage.httpStatus());
    }

    @ExceptionHandler(HttpReadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ApiErrorMessage> handleExceptionHttpReadRequestException(HttpReadRequestException e){
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                errors,
                e.getMessage()
        );
        return new ResponseEntity<>(apiErrorMessage, null, apiErrorMessage.httpStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<ApiErrorMessage> handleAllUncaughtException(Exception e, WebRequest webRequest){
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                errors,
                e.getMessage()
        );
        return new ResponseEntity<>(apiErrorMessage, null, apiErrorMessage.httpStatus());
    }

}

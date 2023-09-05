package br.com.postzy.www.config.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public record ApiErrorMessage(
        Integer httpCode,
        HttpStatus httpStatus,
        List<String> errors, String devMessage
) {
    public ApiErrorMessage(Integer httpCode, HttpStatus httpStatus, String error, String devMessage) {
       this(httpCode, httpStatus, Arrays.asList(error), devMessage);
    }

}

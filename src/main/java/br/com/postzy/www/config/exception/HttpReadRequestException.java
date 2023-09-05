package br.com.postzy.www.config.exception;

public class HttpReadRequestException extends RuntimeException {
    public HttpReadRequestException(String detail) {
        super(detail);
    }

}

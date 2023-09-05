package br.com.postzy.www.config.exception;

public class HttpNoSourchException extends RuntimeException {
    public HttpNoSourchException(String detail) {
        super(detail);
    }

}

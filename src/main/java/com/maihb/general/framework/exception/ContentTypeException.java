package com.maihb.general.framework.exception;

public class ContentTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContentTypeException(String message){
        super(message);
    }

    public ContentTypeException() {
        super();
    }

    public ContentTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentTypeException(Throwable cause) {
        super(cause);
    }

}

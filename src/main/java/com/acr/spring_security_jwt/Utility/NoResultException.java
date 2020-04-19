package com.acr.spring_security_jwt.Utility;

public class NoResultException extends Exception {
    public NoResultException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

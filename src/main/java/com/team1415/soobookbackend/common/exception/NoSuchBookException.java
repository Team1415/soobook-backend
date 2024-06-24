package com.team1415.soobookbackend.common.exception;

public class NoSuchBookException extends RuntimeException {

    public NoSuchBookException(String message) {
        super(message);
    }

    public NoSuchBookException(NoSuchBookException nbbangException) {
        super(nbbangException.getMessage());
    }
}

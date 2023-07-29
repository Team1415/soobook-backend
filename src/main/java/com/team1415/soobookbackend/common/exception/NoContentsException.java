package com.team1415.soobookbackend.common.exception;

public class NoContentsException extends RuntimeException {

    public NoContentsException(String message) {
        super(message);
    }

    public NoContentsException(NoContentsException noContentsException) {
        super(noContentsException.getMessage());
    }

}

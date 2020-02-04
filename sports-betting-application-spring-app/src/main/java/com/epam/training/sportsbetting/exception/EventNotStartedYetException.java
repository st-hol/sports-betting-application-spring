package com.epam.training.sportsbetting.exception;

public class EventNotStartedYetException extends Exception {
    public EventNotStartedYetException() {
    }

    public EventNotStartedYetException(String message) {
        super(message);
    }
}

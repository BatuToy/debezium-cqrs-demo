package com.btoy.debezium.event_bus.exception;

public abstract class EventBusException extends RuntimeException{
    public EventBusException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventBusException(String message) {
        super(message);
    }
}

package com.btoy.debezium.event_bus.exception;

public class HandlerNotFoundException extends EventBusException{
    public HandlerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlerNotFoundException(String message) {
        super(message);
    }
}

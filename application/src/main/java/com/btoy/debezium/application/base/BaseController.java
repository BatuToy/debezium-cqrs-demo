package com.btoy.debezium.application.base;

import com.btoy.debezium.event_bus.publisher.BeanAwarePublisher;

import java.util.List;

public abstract class BaseController extends BeanAwarePublisher {

    public <T> AppResponse<T> respond(int statusCode) {
        return ResponseBuilder.build(statusCode);
    }

    public <T> AppResponse<T> respond(T item, int statusCode) {
        return ResponseBuilder.build(item, statusCode);
    }

    public <T> AppResponse<T> respond(List<T> items, int statusCode) {
        return ResponseBuilder.build(items, statusCode);
    }

    public <T> AppResponse<T> respond(Error errorMessage, int statusCode) {
        return ResponseBuilder.build(errorMessage, statusCode);
    }
}

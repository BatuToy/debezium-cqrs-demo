package com.btoy.debeziım.application.base;


import java.util.List;

final class ResponseBuilder {

    private ResponseBuilder() {
        throw new UnsupportedOperationException("");
    }

    static <T> AppResponse<T> build(T item, int statusCode) {
        return new AppResponse<>(List.of(item), statusCode);
    }

    static <T> AppResponse<T> build(List<T> items, int statusCode) {
        return new AppResponse<>(items, statusCode);
    }

    static <T> AppResponse<T> build(Error errorMessage, int statusCode) {
        return new AppResponse<>(errorMessage,statusCode);
    }

    static <T> AppResponse<T> build(int statusCode) {
        return new AppResponse<>(statusCode);
    }
}

package com.btoy.debezium.application.base;

import java.util.ArrayList;
import java.util.List;

public class AppResponse<T> {

    private List<T> payload;
    private final Error errorMessage;
    private final int statusCode;

    protected AppResponse(List<T> payload, int statusCode) {
        this.statusCode = statusCode;
        this.payload = new ArrayList<>(payload); // In case of immutable issues !
        this.errorMessage = new Error("With no Error(s)");
    }

    protected AppResponse(Error errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    protected  AppResponse(int statusCode) {
        this.statusCode = statusCode;
        this.payload = null;
        this.errorMessage = new Error("With no Error(s)");
    }

}

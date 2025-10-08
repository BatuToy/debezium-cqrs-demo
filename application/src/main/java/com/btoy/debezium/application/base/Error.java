package com.btoy.debezium.application.base;

public class Error {

    private final String errMsg;

    public Error(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }
}

package com.btoy.debezium.domain.product.vo;

public class SkuCode {

    private final String value;

    public SkuCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

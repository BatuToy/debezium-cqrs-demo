package com.btoy.debezium.domain.base.vo;

import java.util.Objects;

public class Rate {

    public static final Rate ZERO = new Rate(Double.valueOf("0"));
    public static final Rate HUNDRED = new Rate(Double.valueOf("100"));

    private final Double value;

    public Rate(Double value) {
        this.value = value;
    }

    public boolean isGreaterThen(Rate then) {
        return this.value > then.getValue();
    }

    public boolean isLowerThen(Rate then) {
        return this.value < then.getValue();
    }

    public boolean isEqualTo(Rate to) {
        return this.value.equals(to.getValue());
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(value, rate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

package com.btoy.debezium.domain.base.event;

import java.time.ZonedDateTime;

public abstract class DomainEvent<T> {

    private final T payload;
    private final ZonedDateTime createdAt;

    protected DomainEvent(T payload, ZonedDateTime createdAt) {
        this.payload = payload;
        this.createdAt = createdAt;
    }

    public T getPayload() {
        return payload;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}

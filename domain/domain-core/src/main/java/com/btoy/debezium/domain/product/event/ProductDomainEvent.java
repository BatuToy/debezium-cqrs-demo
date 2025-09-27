package com.btoy.debezium.domain.product.event;

import com.btoy.debezium.domain.base.event.DomainEvent;
import com.btoy.debezium.domain.product.Product;

import java.time.ZonedDateTime;

public class ProductDomainEvent extends DomainEvent<Product> {
    protected ProductDomainEvent(Product product, ZonedDateTime createdAt) {
        super(product, createdAt);
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    public Product getProduct() {
        return super.getPayload();
    }
}

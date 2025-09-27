package com.btoy.debezium.domain.product.event;

import com.btoy.debezium.domain.product.Product;

import java.time.ZonedDateTime;

public class ProductInitializedEvent extends ProductDomainEvent {
    public ProductInitializedEvent(Product product, ZonedDateTime createdAt) {
        super(product, createdAt);
    }
}

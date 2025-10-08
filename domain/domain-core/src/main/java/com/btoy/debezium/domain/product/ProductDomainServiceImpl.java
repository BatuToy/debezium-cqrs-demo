package com.btoy.debezium.domain.product;

import com.btoy.debezium.domain.product.event.ProductInitializedEvent;
import com.btoy.debezium.domain.product.port.input.ProductDomainService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ProductDomainServiceImpl implements ProductDomainService {

    private static final String UTC = "UTC";

    @Override
    public ProductInitializedEvent validateAndInitializeProduct(Product product) {
        product.validate();
        product.initialize();
        return new ProductInitializedEvent(product, ZonedDateTime.now(ZoneId.of(UTC)));
    }
}

package com.btoy.debezium.domain.product.port.input;

import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.event.ProductInitializedEvent;

public interface ProductDomainService {

    ProductInitializedEvent validateAndInitializeProduct(Product product);
}

package com.btoy.debezium.domain.port.output.jpa;

import com.btoy.debezium.domain.product.Product;

public interface ProductJpaRepositoryPort {

    Product saveProduct(Product product);
}

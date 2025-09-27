package com.btoy.debezium.domain.port.output.repository;

import com.btoy.debezium.domain.product.Product;

public interface ProductRepositoryPort {

    Product saveProduct(Product product);

    // Elastic and Postgres will serve from this port ! Driven Port of the Application (Persistence) !
}

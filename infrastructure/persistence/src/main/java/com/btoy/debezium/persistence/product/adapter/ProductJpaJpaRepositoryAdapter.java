package com.btoy.debezium.persistence.product.adapter;

import com.btoy.debezium.domain.port.output.jpa.ProductJpaRepositoryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.persistence.product.mapper.ProductDataMapper;
import com.btoy.debezium.persistence.product.repository.ProductJpaRepository;
import com.btoy.debezium.shared.annotations.DaoAdapter;
import lombok.RequiredArgsConstructor;

@DaoAdapter
@RequiredArgsConstructor
public class ProductJpaJpaRepositoryAdapter implements ProductJpaRepositoryPort {

    private final ProductJpaRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return ProductDataMapper
                .toModel(productRepository
                        .save(ProductDataMapper
                                .toEntity(product)));
    }

}

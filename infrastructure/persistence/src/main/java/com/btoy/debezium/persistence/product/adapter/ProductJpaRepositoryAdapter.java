package com.btoy.debezium.persistence.product.adapter;

import com.btoy.debezium.domain.port.output.repository.ProductRepositoryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.persistence.product.mapper.ProductDataMapper;
import com.btoy.debezium.persistence.product.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductJpaRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return ProductDataMapper
                .toModel(productRepository
                        .save(ProductDataMapper
                                .toEntity(product)));
    }

}

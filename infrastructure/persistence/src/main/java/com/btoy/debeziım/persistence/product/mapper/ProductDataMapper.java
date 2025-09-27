package com.btoy.debeziım.persistence.product.mapper;

import com.btoy.debezium.domain.base.vo.Money;
import com.btoy.debezium.domain.base.vo.Rate;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.vo.ProductId;
import com.btoy.debezium.domain.product.vo.SkuCode;
import com.btoy.debeziım.persistence.product.entity.ProductEntity;

public final class ProductDataMapper {

    private ProductDataMapper() {
        throw new UnsupportedOperationException("");
    }

    public static ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId().getValue())
                .name(product.getName())
                .brand(product.getBrand())
                .skuCode(product.getSkuCode().getValue())
                .taxRate(product.getTaxRate().getValue())
                .discountRate(product.getDiscountRate().getValue())
                .price(product.getPrice().getAmount())
                .build();
    }

    public static Product toModel(ProductEntity productEntity) {
        return Product.builder()
                .id(new ProductId(productEntity.getId()))
                .name(productEntity.getName())
                .brand(productEntity.getBrand())
                .skuCode(new SkuCode(productEntity.getSkuCode()))
                .taxRate(new Rate(productEntity.getTaxRate()))
                .discountRate(new Rate(productEntity.getDiscountRate()))
                .price(new Money(productEntity.getPrice()))
                .build();
    }
}

package com.btoy.debezium.domain.mapper;

import com.btoy.debezium.domain.base.vo.Money;
import com.btoy.debezium.domain.base.vo.Rate;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.vo.SkuCode;
import com.btoy.debezium.event_bus.command.InitializeProductCommandDto;

public final class ProductMapper {

    private ProductMapper() {
        throw new UnsupportedOperationException("");
    }

    public static Product toInitialProduct(InitializeProductCommandDto commandDto) {
        return Product.builder()
                .name(commandDto.getName())
                .description(commandDto.getDescription())
                .brand(commandDto.getBrand())
                .skuCode(new SkuCode(commandDto.getSkuCode()))
                .taxRate(new Rate(commandDto.getTaxRate()))
                .discountRate(new Rate(commandDto.getDiscountRate()))
                .price(new Money(commandDto.getPrice()))
                .build();
    }
}

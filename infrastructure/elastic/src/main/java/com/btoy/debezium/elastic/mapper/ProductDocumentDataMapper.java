package com.btoy.debezium.elastic.mapper;

import com.btoy.debezium.domain.base.vo.Money;
import com.btoy.debezium.domain.base.vo.Rate;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.vo.ProductId;
import com.btoy.debezium.domain.product.vo.SkuCode;
import com.btoy.debezium.elastic.document.ProductDocument;

import java.math.BigDecimal;
import java.util.UUID;

/*
 * @created 08/10/2025 ~~ 14:59
 * author: batu
 */
public final class ProductDocumentDataMapper {

    private ProductDocumentDataMapper() {
        throw new UnsupportedOperationException("Could not reach this class from outside !");
    }

    public static ProductDocument toDocument(Product product) {
        return ProductDocument.builder()
                .id(product.getId().toString())
                .name(product.getName())
                .description(product.getDescription())
                .skuCode(product.getDescription())
                .price(Double.valueOf(product.getPrice().getAmount().toString()))
                .taxRate(product.getTaxRate().getValue())
                .discountRate(product.getDiscountRate().getValue())
                .build();
    }

    public static Product toDomain(ProductDocument document) {
        return Product.builder()
                .id(new ProductId(UUID.fromString(document.getId())))
                .name(document.getName())
                .description(document.getDescription())
                .skuCode(new SkuCode(document.getSkuCode()))
                .price(Money.of(BigDecimal.valueOf(document.getPrice())))
                .taxRate(new Rate(document.getTaxRate()))
                .discountRate(new Rate(document.getDiscountRate()))
                .build();
    }

}

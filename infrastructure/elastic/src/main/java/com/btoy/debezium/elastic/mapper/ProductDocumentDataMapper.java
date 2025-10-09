package com.btoy.debezium.elastic.mapper;

import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.elastic.document.ProductDocument;
import com.btoy.debezium.event_bus.query.ProductDocumentDto;

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

    public static ProductDocument toDocument(ProductDocumentDto productDocumentDto) {
        return ProductDocument.builder()
                .id(productDocumentDto.getId().toString())
                .name(productDocumentDto.getProductName())
                .description(productDocumentDto.getDescription())
                .skuCode(productDocumentDto.getSkuCode())
                .price(Double.valueOf(productDocumentDto.getPrice().toString()))
                .taxRate(productDocumentDto.getTaxRate())
                .discountRate(productDocumentDto.getDiscountRate())
                .build();
    }

    public static ProductDocumentDto toDocumentDto(ProductDocument document) {
        return ProductDocumentDto.builder()
                .id(UUID.fromString(document.getId()))
                .productName(document.getName())
                .description(document.getDescription())
                .skuCode(document.getSkuCode())
                .price(BigDecimal.valueOf(document.getPrice()))
                .taxRate(document.getTaxRate())
                .discountRate(document.getDiscountRate())
                .build();
    }

}

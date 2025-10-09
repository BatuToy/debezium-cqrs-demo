package com.btoy.debezium.event_bus.query;

/*
 * @created 09/10/2025 ~~ 09:12
 * author: batu
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class ProductDocumentDto {
    private final UUID id;
    private final String description;
    private final String productName;
    private final BigDecimal price;
    private final String skuCode;
    private final Double taxRate;
    private final Double discountRate;
}

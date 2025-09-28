package com.btoy.debezium.event_bus.command;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class InitializeProductCommandDto implements CommandCase {

    private final String name;
    private final String brand;
    private final String skuCode;
    private final Double taxRate;
    private final Double discountRate;
    private final BigDecimal price;

}

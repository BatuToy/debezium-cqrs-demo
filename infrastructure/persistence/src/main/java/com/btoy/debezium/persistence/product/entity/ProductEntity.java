package com.btoy.debezium.persistence.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "t_product", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SKU_CODE"}, name = "product_unique_sku_code")
},
        indexes = {
                @Index(name = "idx_product_sku_code", columnList = "STOCK_CODE")
})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private UUID id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "BRAND_NAME", unique = true, nullable = false)
    private String brand;

    @Column(name = "STOCK_CODE", nullable = false, unique = true)
    private String skuCode;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "TAX_RATE", nullable = false)
    private Double taxRate;

    @Column(name = "DISCOUNT_RATE")
    private Double discountRate;
}

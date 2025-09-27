package com.btoy.debezium.domain.product;

import com.btoy.debezium.domain.base.entity.BaseEntity;
import com.btoy.debezium.domain.base.vo.Money;
import com.btoy.debezium.domain.base.vo.Rate;
import com.btoy.debezium.domain.product.exception.ProductDomainException;
import com.btoy.debezium.domain.product.vo.ProductId;
import com.btoy.debezium.domain.product.vo.SkuCode;

import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

public class Product extends BaseEntity<ProductId> {

    private static final Logger logger = Logger.getLogger(Product.class.getSimpleName());

    private final String name;
    private final String brand;
    private final Rate discountRate;
    private final Rate taxRate;
    private final Money price;
    private final SkuCode skuCode;

    void validate() {
        validateInitialProduct();
        validateProductName();
        validateProductBrandName();
        validateDiscountRate();
        validateTaxRate();
        validatePrice();
        validateSkuCode();
    }

    void initialize() {
        super.setId(new ProductId(UUID.randomUUID()));
    }

    private void validateInitialProduct() {
        if (Objects.nonNull(super.getId())) {
            logger.severe("Initial product could not contain id!");
            throw new RuntimeException("Initial Product could not contain id!");
        }
    }

    private void validateProductName() {
        if (this.name.length() < 3 || this.name.length() > 20) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private void validateProductBrandName() {
        if (this.brand.length() < 3 || this.brand.length() > 20) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private void validateDiscountRate() {
        if (this.discountRate.isLowerThen(Rate.ZERO) || this.discountRate.isGreaterThen(Rate.HUNDRED)) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private void validateTaxRate() {
        if (this.taxRate.isLowerThen(Rate.ZERO) || this.taxRate.isGreaterThen(Rate.HUNDRED)) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private void validatePrice() {
        if (this.price.isLowerThen(Money.ZERO) || this.price.isEqualTo(Money.ZERO)) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private void validateSkuCode() {
        if (!this.skuCode.getValue().matches("^[A-Z]{3}-\\d{5}-[A-Z]-[A-Z]{2}$")) {
            logger.severe("");
            throw new ProductDomainException("");
        }
    }

    private Product(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
        brand = builder.brand;
        discountRate = builder.discountRate;
        taxRate = builder.taxRate;
        price = builder.price;
        skuCode = builder.skuCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ProductId id;
        private String name;
        private String brand;
        private Rate discountRate;
        private Rate taxRate;
        private Money price;
        private SkuCode skuCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ProductId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder brand(String val) {
            brand = val;
            return this;
        }

        public Builder discountRate(Rate val) {
            discountRate = val;
            return this;
        }

        public Builder taxRate(Rate val) {
            taxRate = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder skuCode(SkuCode val) {
            skuCode = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Rate getDiscountRate() {
        return discountRate;
    }

    public Rate getTaxRate() {
        return taxRate;
    }

    public Money getPrice() {
        return price;
    }

    public SkuCode getSkuCode() {
        return skuCode;
    }
}

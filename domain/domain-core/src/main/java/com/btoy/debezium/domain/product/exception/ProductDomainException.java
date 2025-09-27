package com.btoy.debezium.domain.product.exception;

import com.btoy.debezium.domain.base.exception.DomainException;

public class ProductDomainException extends DomainException {
    public ProductDomainException(String message) {
        super(message);
    }

    public ProductDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}

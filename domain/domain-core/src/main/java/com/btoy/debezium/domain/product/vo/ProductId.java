package com.btoy.debezium.domain.product.vo;

import com.btoy.debezium.domain.base.vo.BaseId;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}

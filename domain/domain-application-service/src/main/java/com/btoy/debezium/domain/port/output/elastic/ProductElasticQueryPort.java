package com.btoy.debezium.domain.port.output.elastic;

import com.btoy.debezium.event_bus.query.ProductDocumentDto;

import java.util.List;

/*
 * @created 09/10/2025 ~~ 09:50
 * author: batu
 */
public interface ProductElasticQueryPort {

    List<ProductDocumentDto> searchProducts(String query);
}

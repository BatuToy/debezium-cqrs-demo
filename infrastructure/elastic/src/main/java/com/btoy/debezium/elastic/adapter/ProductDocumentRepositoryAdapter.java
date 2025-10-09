package com.btoy.debezium.elastic.adapter;

/*
 * @created 08/10/2025 ~~ 15:07
 * author: batu
 */

import com.btoy.debezium.domain.port.output.elastic.ProductElasticQueryPort;
import com.btoy.debezium.elastic.repository.ProductDocumentRepository;
import com.btoy.debezium.event_bus.query.ProductDocumentDto;
import com.btoy.debezium.shared.annotations.DaoAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DaoAdapter
@RequiredArgsConstructor
public class ProductDocumentRepositoryAdapter implements ProductElasticQueryPort
{

    private final ProductDocumentRepository productDocumentRepository;

    @Override
    public List<ProductDocumentDto> searchProducts(String query) {
        return List.of();
    }
}

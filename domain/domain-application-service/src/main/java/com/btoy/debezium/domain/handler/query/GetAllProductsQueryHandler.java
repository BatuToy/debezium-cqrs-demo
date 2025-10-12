package com.btoy.debezium.domain.handler.query;

import com.btoy.debezium.domain.mapper.ProductMapper;
import com.btoy.debezium.domain.port.output.elastic.ProductElasticQueryPort;
import com.btoy.debezium.event_bus.handler.QueryHandler;
import com.btoy.debezium.event_bus.publisher.ObservablePublisher;
import com.btoy.debezium.event_bus.query.GetAllProductsQuery;
import com.btoy.debezium.event_bus.query.ProductDocumentDto;
import com.btoy.debezium.shared.annotations.DomainComponent;

import java.util.List;

/*
 * @created 09/10/2025 ~~ 12:04
 * author: batu
 */
@DomainComponent
public class GetAllProductsQueryHandler extends ObservablePublisher implements QueryHandler<List<ProductDocumentDto>, GetAllProductsQuery> {

    private final ProductElasticQueryPort productElasticQueryPort;

    public GetAllProductsQueryHandler(ProductElasticQueryPort productElasticQueryPort) {
        register(this, GetAllProductsQuery.class);
        this.productElasticQueryPort = productElasticQueryPort;
    }

    @Override
    public List<ProductDocumentDto> handle(GetAllProductsQuery queryDto) {
        return productElasticQueryPort.searchWithQuery(queryDto.getSearchQuery(), queryDto.getPage(), queryDto.getSize())
                .stream().map(ProductMapper::toProductDocumentDto).toList();
    }
}

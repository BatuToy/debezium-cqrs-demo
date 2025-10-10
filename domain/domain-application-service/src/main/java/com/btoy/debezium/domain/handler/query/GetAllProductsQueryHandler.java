package com.btoy.debezium.domain.handler.query;

import com.btoy.debezium.event_bus.handler.QueryHandler;
import com.btoy.debezium.event_bus.publisher.ObservablePublisher;
import com.btoy.debezium.event_bus.query.GetAllProductsQuery;
import com.btoy.debezium.event_bus.query.ProductDocumentDto;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @created 09/10/2025 ~~ 12:04
 * author: batu
 */
@Component
public class GetAllProductsQueryHandler extends ObservablePublisher implements QueryHandler<List<ProductDocumentDto>, GetAllProductsQuery> {

    public GetAllProductsQueryHandler() {
        register(this, GetAllProductsQuery.class);
    }

    @Override
    public List<ProductDocumentDto> handle(GetAllProductsQuery queryDto) {
        return List.of();
    }
}

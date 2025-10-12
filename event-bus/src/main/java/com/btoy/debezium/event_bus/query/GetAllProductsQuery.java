package com.btoy.debezium.event_bus.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * @created 09/10/2025 ~~ 16:54
 * author: batu
 */
@AllArgsConstructor
@Getter
public class GetAllProductsQuery implements QueryCase{

    private final String searchQuery;
    private final Integer page;
    private final Integer size;
}

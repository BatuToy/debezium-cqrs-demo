package com.btoy.debezium.event_bus.handler;

import com.btoy.debezium.event_bus.query.QueryCase;

public interface QueryHandler<R, I extends QueryCase> {
    R handle(I queryDto);
}

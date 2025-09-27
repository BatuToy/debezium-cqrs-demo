package com.btoy.debezium.event_bus.registry;

import com.btoy.debezium.event_bus.command.CommandCase;
import com.btoy.debezium.event_bus.handler.CommandHandler;
import com.btoy.debezium.event_bus.handler.QueryHandler;
import com.btoy.debezium.event_bus.publisher.BeanAwarePublisher;
import com.btoy.debezium.event_bus.query.QueryCase;

public abstract class ObservablePublisher extends BeanAwarePublisher {

    public <R, I extends CommandCase> void register(CommandHandler<R, I> handler, Class<I> commandDto) {
        HandlerRegistry.INSTANCE.register(commandDto, handler);
    }

    public <R, I extends QueryCase> void register(QueryHandler<R, I> handler, Class<I> queryDto) {
        HandlerRegistry.INSTANCE.register(queryDto, handler);
    }
}

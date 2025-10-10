package com.btoy.debezium.event_bus.publisher;

import com.btoy.debezium.event_bus.command.CommandCase;
import com.btoy.debezium.event_bus.exception.HandlerNotFoundException;
import com.btoy.debezium.event_bus.handler.CommandHandler;
import com.btoy.debezium.event_bus.handler.QueryHandler;
import com.btoy.debezium.event_bus.query.QueryCase;
import com.btoy.debezium.event_bus.registry.HandlerRegistry;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;


@Component
public abstract class BeanAwarePublisher {

    private static final Logger logger = Logger.getLogger(BeanAwarePublisher.class.getSimpleName());

    @SuppressWarnings("unchecked")
    public <R, I extends QueryCase> R publish(I queryDto) {
        QueryHandler<R, I> handler = HandlerRegistry.INSTANCE.fetchQueryHandlerFromRegistry(queryDto);
        validateQueryHandler(handler, queryDto);
        return handler.handle(queryDto);
    }

    @SuppressWarnings("unchecked")
    public <R, I extends CommandCase> R publish(I commandDto) {
        CommandHandler<R, I> handler = HandlerRegistry.INSTANCE.fetchCommandHandlerFromRegistry(commandDto);
        validateCommandHandler(handler, commandDto);
        return handler.handle(commandDto);
    }

    private <R, I extends CommandCase> void validateCommandHandler(CommandHandler<R, I> handler, I commandDto) {
        if (Objects.isNull(handler)) {
            logger.severe("[%EVENT-BUS-COMMAND-TRACE%]-- Command handler could not be found in the handler registry with command dto= " + commandDto.getClass().getSimpleName());
            throw new HandlerNotFoundException("[%EVENT-BUS-COMMAND-TRACE%]-- Command handler could not be found in the handler registry with command dto= " + commandDto.getClass().getSimpleName());
        }
    }

    private <R, I extends QueryCase> void validateQueryHandler(QueryHandler<R, I> handler, I queryDto) {
        if (Objects.isNull(handler)) {
            logger.severe("[%EVENT-BUS-QUERY-TRACE%]-- Query handler could not be found in the handler registry with query dto= " + queryDto.getClass().getSimpleName());
            throw new HandlerNotFoundException("[%EVENT-BUS-QUERY-TRACE%]-- Query handler could not be found in the handler registry with query dto= " + queryDto.getClass().getSimpleName());
        }
    }
}

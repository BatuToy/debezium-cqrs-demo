package com.btoy.debezium.event_bus.registry;

import com.btoy.debezium.event_bus.command.CommandCase;
import com.btoy.debezium.event_bus.handler.CommandHandler;
import com.btoy.debezium.event_bus.handler.QueryHandler;
import com.btoy.debezium.event_bus.query.QueryCase;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HandlerRegistry {

    private static final Logger logger = Logger.getLogger(HandlerRegistry.INSTANCE.getClass().getSimpleName());

    private Map<Class<? extends CommandCase>, CommandHandler<?, ? extends CommandCase>> commandHandlerRegistry;
    private Map<Class<? extends QueryCase>, QueryHandler<?, ? extends QueryCase>> queryHandlerRegistry;

    public static final HandlerRegistry INSTANCE = new HandlerRegistry();

    private HandlerRegistry() {
        this.commandHandlerRegistry = new HashMap<>();
        this.queryHandlerRegistry = new HashMap<>();
    }

    public <R, I extends CommandCase> void register(Class<I> commandDto, CommandHandler<R, I> commandHandler) {
        commandHandlerRegistry.put(commandDto, commandHandler);
        logger.info("Command Handler= " + commandHandler.getClass().getSimpleName() + " registered successfully with commandDto= "+ commandDto.getSimpleName() +" !");
    }

    public <R, I extends QueryCase> void register(Class<I> queryDto, QueryHandler<R, I> queryHandler) {
        queryHandlerRegistry.put(queryDto, queryHandler);
        logger.info("Query Handler= " + queryHandler.getClass().getSimpleName() + " registered successfully with commandDto= "+ queryDto.getSimpleName() +" !");
    }

    @SuppressWarnings("unchecked")
    public <R, I extends CommandCase> CommandHandler<R, I> fetchCommandHandlerFromRegistry(I commandDto) {
        return (CommandHandler<R, I>) commandHandlerRegistry.get(commandDto.getClass());
    }

    @SuppressWarnings("unchecked")
    public <R, I extends QueryCase> QueryHandler<R, I> fetchQueryHandlerFromRegistry(I queryDto) {
        return (QueryHandler<R, I>) queryHandlerRegistry.get(queryDto.getClass());
    }

}

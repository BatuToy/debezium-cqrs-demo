package com.btoy.debezium.event_bus.handler;

import com.btoy.debezium.event_bus.command.CommandCase;

public interface CommandHandler<R, I extends CommandCase> {
    R handle(I commandDto);
}

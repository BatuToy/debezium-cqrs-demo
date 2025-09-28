package com.btoy.debezium.event_bus.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class InitializeProductResponseDto {

    private final UUID id;
}

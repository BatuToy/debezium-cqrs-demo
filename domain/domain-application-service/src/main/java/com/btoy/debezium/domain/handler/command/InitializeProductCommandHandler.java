package com.btoy.debezium.domain.handler.command;

import com.btoy.debezium.domain.mapper.ProductMapper;
import com.btoy.debezium.domain.port.output.repository.ProductRepositoryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.event.ProductInitializedEvent;
import com.btoy.debezium.domain.product.port.input.ProductDomainService;
import com.btoy.debezium.event_bus.command.InitializeProductCommandDto;
import com.btoy.debezium.event_bus.command.InitializeProductResponseDto;
import com.btoy.debezium.event_bus.handler.CommandHandler;
import com.btoy.debezium.event_bus.publisher.ObservablePublisher;
import org.springframework.stereotype.Component;

@Component
public class InitializeProductCommandHandler extends ObservablePublisher implements CommandHandler<InitializeProductResponseDto, InitializeProductCommandDto> {

    private final ProductDomainService productDomainService;
    private final ProductRepositoryPort productRepositoryPort;

    public InitializeProductCommandHandler(ProductDomainService productDomainService,
                                           ProductRepositoryPort productRepositoryPort) {
        register(this, InitializeProductCommandDto.class);
        this.productRepositoryPort = productRepositoryPort;
        this.productDomainService = productDomainService;
    }

    @Override
    public InitializeProductResponseDto handle(InitializeProductCommandDto commandDto) {
        Product initialProduct = ProductMapper.toInitialProduct(commandDto);
        ProductInitializedEvent productInitializedEvent = productDomainService.validateAndInitializeProduct(initialProduct);
        Product initializedProduct = productInitializedEvent.getProduct();
        productRepositoryPort.saveProduct(initializedProduct);
        return new InitializeProductResponseDto(initializedProduct.getId().getValue());
    }
}

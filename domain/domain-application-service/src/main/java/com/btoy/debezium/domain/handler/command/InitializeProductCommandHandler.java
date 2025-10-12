package com.btoy.debezium.domain.handler.command;

import com.btoy.debezium.domain.mapper.ProductMapper;
import com.btoy.debezium.domain.port.output.jpa.ProductJpaRepositoryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.domain.product.event.ProductInitializedEvent;
import com.btoy.debezium.domain.product.port.input.ProductDomainService;
import com.btoy.debezium.domain.service.ProductQuerySyncService;
import com.btoy.debezium.event_bus.command.InitializeProductCommandDto;
import com.btoy.debezium.event_bus.command.InitializeProductResponseDto;
import com.btoy.debezium.event_bus.handler.CommandHandler;
import com.btoy.debezium.event_bus.publisher.ObservablePublisher;
import com.btoy.debezium.shared.annotations.DomainComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@DomainComponent
public class InitializeProductCommandHandler extends ObservablePublisher implements CommandHandler<InitializeProductResponseDto, InitializeProductCommandDto> {

    private final ProductDomainService productDomainService;
    private final ProductQuerySyncService productQuerySyncService;
    private final ProductJpaRepositoryPort productJpaRepositoryPort;

    public InitializeProductCommandHandler(ProductDomainService productDomainService,
                                           ProductQuerySyncService productQuerySyncService,
                                           ProductJpaRepositoryPort productJpaRepositoryPort) {
        register(this, InitializeProductCommandDto.class);
        this.productQuerySyncService = productQuerySyncService;
        this.productJpaRepositoryPort = productJpaRepositoryPort;
        this.productDomainService = productDomainService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public InitializeProductResponseDto handle(InitializeProductCommandDto commandDto) {
        Product initialProduct = ProductMapper.toInitialProduct(commandDto);
        ProductInitializedEvent productInitializedEvent = productDomainService.validateAndInitializeProduct(initialProduct);
        Product initializedProduct = productInitializedEvent.getProduct();
        productJpaRepositoryPort.saveProduct(initializedProduct);
        productQuerySyncService.sync(initializedProduct);
        return new InitializeProductResponseDto(initializedProduct.getId().getValue());
    }
}

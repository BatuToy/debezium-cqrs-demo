package com.btoy.debezium.app;

import com.btoy.debezium.domain.product.ProductDomainServiceImpl;
import com.btoy.debezium.domain.product.port.input.ProductDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeanConfiguration {

    @Bean
    public ProductDomainService productDomainServiceBean() {
        return new ProductDomainServiceImpl();
    }
}

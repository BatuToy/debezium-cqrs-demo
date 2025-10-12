package com.btoy.debezium.domain.service;

import com.btoy.debezium.domain.port.output.elastic.ProductElasticQueryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.shared.annotations.DomainComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

/*
 * @created 10/10/2025 ~~ 09:55
 * author: batu
 */
@RequiredArgsConstructor
@DomainComponent
public class ProductQuerySyncService {

    private final ProductElasticQueryPort productElasticQueryPort;

    private static final Logger logger = Logger.getLogger(ProductQuerySyncService.class.getSimpleName());

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE)
    public void sync(Product product) {
        try {
            logger.info("Syncing the product= " + product.toString());
            productElasticQueryPort.saveDoc(product);
        } catch (OptimisticLockingFailureException exc) {
            logger.severe(exc.getMessage());
            throw new RuntimeException(exc.getMessage());
        }
    }
}

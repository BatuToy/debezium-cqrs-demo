package com.btoy.debezium.domain.service;

import com.btoy.debezium.domain.port.output.elastic.ProductElasticQueryPort;
import com.btoy.debezium.domain.product.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * @created 10/10/2025 ~~ 09:55
 * author: batu
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class ProductQuerySyncService {

    private final ProductElasticQueryPort productElasticQueryPort;


    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE)
    public void sync(Product product) {
        try {
            log.info("Syncing the product= {}" , product.toString());
            productElasticQueryPort.saveDoc(product);
        } catch (OptimisticLockingFailureException exc) {
            log.debug(exc.getMessage(), exc);
            throw new RuntimeException(exc.getMessage());
        }
    }

}

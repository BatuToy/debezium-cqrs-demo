package com.btoy.debezium.elastic.adapter;

/*
 * @created 08/10/2025 ~~ 15:07
 * author: batu
 */

import com.btoy.debezium.domain.port.output.elastic.ProductElasticQueryPort;
import com.btoy.debezium.domain.product.Product;
import com.btoy.debezium.elastic.mapper.ProductDocumentDataMapper;
import com.btoy.debezium.elastic.repository.ProductDocumentRepository;
import com.btoy.debezium.shared.annotations.DaoAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.logging.Logger;

@DaoAdapter
@RequiredArgsConstructor
public class ProductDocumentRepositoryAdapter implements ProductElasticQueryPort {

    private final ProductDocumentRepository productDocumentRepository;

    private static final Logger logger = Logger.getLogger(ProductDocumentRepositoryAdapter.class.getSimpleName());

    @Override
    public List<Product> searchWithQuery(String query, int page, int size) {
        return productDocumentRepository.findProductDocumentBySkuCode(query, PageRequest.of(page, size))
                .map(ProductDocumentDataMapper::toDomain).toList();
    }

    @Override
    public void saveDoc(Product product) {
        productDocumentRepository.save(ProductDocumentDataMapper.toDocument(product));
        logger.info("Product document synced successfully in to elastic instance !");
    }


}

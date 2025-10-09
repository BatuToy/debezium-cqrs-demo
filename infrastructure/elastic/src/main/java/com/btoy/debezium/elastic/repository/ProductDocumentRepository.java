package com.btoy.debezium.elastic.repository;

import com.btoy.debezium.elastic.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/*
 * @created 08/10/2025 ~~ 15:01
 * author: batu
 */
@Repository
public interface ProductDocumentRepository  extends ElasticsearchRepository<ProductDocument, String> {
}

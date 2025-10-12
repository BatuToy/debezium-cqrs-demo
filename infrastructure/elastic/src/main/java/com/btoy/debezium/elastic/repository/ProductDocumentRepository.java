package com.btoy.debezium.elastic.repository;

import com.btoy.debezium.elastic.document.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 08/10/2025 ~~ 15:01
 * author: batu
 */
@Repository
public interface ProductDocumentRepository  extends ElasticsearchRepository<ProductDocument, String> {
    
    Page<ProductDocument> findByName(String name, Pageable pageable);
}

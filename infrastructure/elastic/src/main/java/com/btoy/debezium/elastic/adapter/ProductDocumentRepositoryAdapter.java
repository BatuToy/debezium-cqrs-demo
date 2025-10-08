package com.btoy.debezium.elastic.adapter;

/*
 * @created 08/10/2025 ~~ 15:07
 * author: batu
 */

import com.btoy.debezium.elastic.repository.ProductDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDocumentRepositoryAdapter {

    private final ProductDocumentRepository productDocumentRepository;


}

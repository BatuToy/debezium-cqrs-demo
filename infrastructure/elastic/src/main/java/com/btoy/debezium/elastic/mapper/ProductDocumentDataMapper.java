package com.btoy.debezium.elastic.mapper;

import com.btoy.debezium.elastic.document.ProductDocument;
import org.springframework.stereotype.Component;

/*
 * @created 08/10/2025 ~~ 14:59
 * author: batu
 */
public final class ProductDocumentDataMapper {

    private ProductDocumentDataMapper() {
        throw new UnsupportedOperationException("Could not reach this class from outside !");
    }

    public static ProductDocument toDocument() {
        return null;
    }

    // toDto will implemented as well !

}

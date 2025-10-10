package com.btoy.debezium.elastic.document;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Builder
@Getter
@Document(indexName = "product")
public class ProductDocument {

    @Id
    @Field(type = FieldType.Text, name = "PRODUCT_ID")
    private String id;

    @Field(type = FieldType.Text, name = "PRODUCT_NAME")
    private String name;

    @Field(type = FieldType.Text, name = "DESCRIPTION")
    private String description;

    @Field(type = FieldType.Double, name = "PRICE")
    private Double price;

    @Field(type = FieldType.Keyword, name = "STOCK_CODE")
    private String skuCode;

    @Field(type = FieldType.Double, name = "TAX_RATE")
    private Double taxRate;

    @Field(type = FieldType.Double, name = "DISCOUNT_RATE")
    private Double discountRate;

}

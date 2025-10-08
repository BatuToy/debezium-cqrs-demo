package com.btoy.debezium.persistence.product.repository;

import com.btoy.debezium.persistence.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {}

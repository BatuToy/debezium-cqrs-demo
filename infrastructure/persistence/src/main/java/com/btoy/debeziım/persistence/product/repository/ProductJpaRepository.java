package com.btoy.debeziım.persistence.product.repository;

import com.btoy.debeziım.persistence.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {}

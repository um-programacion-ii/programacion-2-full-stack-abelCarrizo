package com.example.hexagonal.hexagonalbasico.product.infrastructure.persistence.repository;


import com.example.hexagonal.hexagonalbasico.product.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}

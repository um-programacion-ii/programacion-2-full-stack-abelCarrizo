package com.example.hexagonal.hexagonalbasico.product.domain.ports.out;

import com.example.hexagonal.hexagonalbasico.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Optional<Product> update(Long id, Product product);
    boolean deleteById(Long id);
}

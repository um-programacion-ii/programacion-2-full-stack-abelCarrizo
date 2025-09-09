package com.example.hexagonal.hexagonalbasico.product.domain.ports.in;

import com.example.hexagonal.hexagonalbasico.product.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}

package com.example.hexagonal.hexagonalbasico.product.domain.ports.in;

import com.example.hexagonal.hexagonalbasico.product.domain.model.Product;

import java.util.List;

public interface GetAllProductsUseCase {

    List<Product> getAllProducts();

}

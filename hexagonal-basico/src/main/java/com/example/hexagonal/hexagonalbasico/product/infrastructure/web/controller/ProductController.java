package com.example.hexagonal.hexagonalbasico.product.infrastructure.web.controller;

import com.example.hexagonal.hexagonalbasico.product.domain.model.Product;
import com.example.hexagonal.hexagonalbasico.product.domain.ports.in.CreateProductUseCase;
import com.example.hexagonal.hexagonalbasico.product.domain.ports.in.GetAllProductsUseCase;
import com.example.hexagonal.hexagonalbasico.product.infrastructure.web.dto.ProductRequest;
import com.example.hexagonal.hexagonalbasico.product.infrastructure.web.dto.ProductResponse;
import com.example.hexagonal.hexagonalbasico.product.infrastructure.web.mapper.ProductDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final GetAllProductsUseCase getAllProductsUseCase;
    private CreateProductUseCase createProductUseCase;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping("/test")
    public ResponseEntity<String> test(){

        return ResponseEntity.ok("Hello World");

    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest){

        Product product = productDtoMapper.toDomain(productRequest);
        Product createdProduct = createProductUseCase.createProduct(product);
        return new ResponseEntity<>(productDtoMapper.toResponse(createdProduct), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){

        List<ProductResponse> productResponses = getAllProductsUseCase.getAllProducts()
                .stream()
                .map(productDtoMapper::toResponse)
                .toList();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);

    }

}

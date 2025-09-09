package com.example.hexagonal.hexagonalbasico.product.infrastructure.persistence.repository;

import com.example.hexagonal.hexagonalbasico.product.domain.model.Product;
import com.example.hexagonal.hexagonalbasico.product.domain.ports.out.ProductRepository;
import com.example.hexagonal.hexagonalbasico.product.infrastructure.persistence.entity.ProductEntity;
import com.example.hexagonal.hexagonalbasico.product.infrastructure.persistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        ProductEntity savedProduct = jpaProductRepository.save(productEntity);
        return productMapper.toDomain(savedProduct);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

}

package com.programmingtechie.product_service.service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.model.Product;
import com.programmingtechie.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static com.programmingtechie.product_service.model.Product.*;
import static org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product =Product.builder()
                .name( ProductRequest.getName())
                .description(productRequest.getDescription()
                        .price(productRequest.getPrice())
                                .build();

        productRepository.save(product);
        log.info("Product {} is saved!", product.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> Products = productRepository.findAll();

        return Products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}


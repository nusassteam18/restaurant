package com.ss.restaurant.service;

import com.ss.restaurant.entity.Product;
import com.ss.restaurant.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    Logger log =  LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByRestaurantId(Long restaurantId) {
        List<Product> products = productRepository.findByRestaurantId(restaurantId);

        return products;
    }

}

package com.ss.restaurant.service;

import com.ss.restaurant.dto.ProductDTO;
import com.ss.restaurant.entity.Product;
import com.ss.restaurant.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProductsByRestaurantId(Long restaurantId) {
        List<Product> products = productRepository.findByRestaurantId(restaurantId);
        ArrayList<ProductDTO> result = new ArrayList<>();
        for (Product product : products) {
            result.add(
                    new ProductDTO(
                    product.getProductId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getImageId(),
                    restaurantId
                    )
            );
        }
        return result;
    }
}

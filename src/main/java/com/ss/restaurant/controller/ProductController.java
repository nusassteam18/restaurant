package com.ss.restaurant.controller;

import com.ss.restaurant.entity.Product;
import com.ss.restaurant.entity.Product;
import com.ss.restaurant.responseDTO.ProductTruncatedDTO;
import com.ss.restaurant.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/restaurants/products")
public class ProductController {
    Logger log =  LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> products = productService.getProducts();

        if (products != null)
            return ResponseEntity.ok(products);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/truncated/{restaurantId}")
    public ResponseEntity<List<ProductTruncatedDTO>> getProductsTruncatedByRestaurantId(@PathVariable Long restaurantId) {

        List<ProductTruncatedDTO> productTruncatedDTOS = productService.getProductsTruncatedByRestaurantId(restaurantId);

        if (productTruncatedDTOS != null)
            return ResponseEntity.ok(productTruncatedDTOS);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Product>> getProductsByRestaurantId(@PathVariable Long restaurantId) {

        List<Product> products = productService.getProductsByRestaurantId(restaurantId);

        if (products != null)
            return ResponseEntity.ok(products);

        return ResponseEntity.notFound().build();
    }
}

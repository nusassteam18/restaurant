package com.ss.restaurant.controller;


import com.ss.restaurant.dto.ProductDTO;
import com.ss.restaurant.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/restaurants/products")
public class ProductController {
    Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getProductsByRestaurantId(@RequestParam Long restaurantId) {
        List<ProductDTO> products = productService.getProductsByRestaurantId(restaurantId);
        return ResponseEntity.ok(products);
    }
}

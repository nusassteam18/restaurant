package com.ss.restaurant.service;

import com.ss.restaurant.entity.Product;
import com.ss.restaurant.repository.ProductRepository;
import com.ss.restaurant.responseDTO.ProductTruncatedDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProducts() {
        List<Product> mockProducts = List.of(new Product(1L, "Pizza", "Cheesy", BigDecimal.ONE, null));
        when(productRepository.findAll()).thenReturn(mockProducts);

        List<Product> result = productService.getProducts();

        assertEquals(1, result.size());
        assertEquals("Pizza", result.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testGetProductsByRestaurantId() {
        Long restaurantId = 100L;
        List<Product> mockProducts = List.of(new Product(2L, "Burger", "Spicy", BigDecimal.ONE, null));
        when(productRepository.findByRestaurantId(restaurantId)).thenReturn(mockProducts);

        List<Product> result = productService.getProductsByRestaurantId(restaurantId);

        assertEquals(1, result.size());
        assertEquals("Burger", result.get(0).getName());
        verify(productRepository, times(1)).findByRestaurantId(restaurantId);
    }

    @Test
    void testGetProductsTruncatedByRestaurantId() {
        Long restaurantId = 200L;
        List<ProductTruncatedDTO> mockTruncated = List.of(new ProductTruncatedDTO(1L, "Pasta"));
        when(productRepository.findProductsTruncatedByRestaurantId(restaurantId)).thenReturn(mockTruncated);

        List<ProductTruncatedDTO> result = productService.getProductsTruncatedByRestaurantId(restaurantId);

        assertEquals(1, result.size());
        assertEquals("Pasta", result.get(0).getName());
        verify(productRepository, times(1)).findProductsTruncatedByRestaurantId(restaurantId);
    }
}

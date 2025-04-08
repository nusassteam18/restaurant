package com.ss.restaurant.repository;

import com.ss.restaurant.entity.Product;
import com.ss.restaurant.responseDTO.ProductTruncatedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRestaurantId(Long restaurantId);

    @Query(value = "SELECT new com.ss.restaurant.responseDTO.ProductTruncatedDTO(p.productId as productId, p.name as name) FROM Product p WHERE p.restaurantId = :restaurantId")
    List<ProductTruncatedDTO> findProductsTruncatedByRestaurantId(@Param("restaurantId") Long restaurantId);
}
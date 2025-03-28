package com.ss.restaurant.repository;

import com.ss.restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT * FROM product WHERE restaurant_id = ?1",
            nativeQuery = true
    )
    List<Product> findByRestaurantId(Long restaurantId);

}
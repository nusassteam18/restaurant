package com.ss.restaurant.repository;

import com.ss.restaurant.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRestaurantId(Long restaurantId);
}
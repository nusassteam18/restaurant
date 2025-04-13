package com.ss.restaurant.repository;

import com.ss.restaurant.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRestaurantId(Long restaurantId);
    Optional<Rating> findByRestaurantIdAndCustomerId(Long restaurantId, Long customerId);
    Optional<Rating> findByRatingIdAndRestaurantIdAndCustomerId(Long ratingId, Long restaurantId, Long customerId);
}
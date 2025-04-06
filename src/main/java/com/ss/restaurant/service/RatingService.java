package com.ss.restaurant.service;

import com.ss.restaurant.entity.Rating;
import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.repository.RatingRepository;
import com.ss.restaurant.repository.RestaurantRepository;
import com.ss.restaurant.responseDTO.RatingResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private final RatingRepository ratingRepository;

    @Autowired final RestaurantRepository restaurantRepository;

    public RatingService(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public RatingResponseDTO getRatingsByRestaurantId(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

        List<Rating> ratings = ratingRepository.findByRestaurantId(restaurantId);

        return new RatingResponseDTO(
                restaurantId,
                restaurant.getAverageScore(),
                restaurant.getRateCount(),
                ratings
        );
    }
}

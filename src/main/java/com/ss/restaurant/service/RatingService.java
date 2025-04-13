package com.ss.restaurant.service;

import com.ss.restaurant.entity.Rating;
import com.ss.restaurant.entity.Restaurant;
import com.ss.restaurant.repository.RatingRepository;
import com.ss.restaurant.repository.RestaurantRepository;
import com.ss.restaurant.requestDTO.rating.RatingRequestDTO;
import com.ss.restaurant.requestDTO.rating.RatingUpdateDTO;
import com.ss.restaurant.responseDTO.RatingResponseDTO;
import com.ss.restaurant.responseDTO.UserRatingResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<UserRatingResponseDTO> getRatingByRestaurantIdAndCustomerId(Long restaurantId, Long customerId){
        return ratingRepository.findByRestaurantIdAndCustomerId(restaurantId, customerId)
                .map(rating -> new UserRatingResponseDTO(
                        rating.getRatingId(),
                        rating.getScore(),
                        rating.getDescription(),
                        rating.getCreatedAt()
                ));
    }

    public UserRatingResponseDTO submitRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        rating.setRestaurantId(ratingRequestDTO.getRestaurantId());
        rating.setCustomerId(ratingRequestDTO.getCustomerId());
        rating.setScore(ratingRequestDTO.getScore());
        rating.setDescription(ratingRequestDTO.getDescription());

        Rating saved = ratingRepository.save(rating);
        return new UserRatingResponseDTO(
                saved.getRatingId(),
                saved.getScore(),
                saved.getDescription(),
                saved.getCreatedAt()
        );
    }

    public Optional<Rating> getRatingByRatingIdAndRestaurantIdAndCustomerId(Long ratingId, Long restaurantId, Long customerId){
        return ratingRepository.findByRatingIdAndRestaurantIdAndCustomerId(ratingId, restaurantId, customerId);
    }

    public UserRatingResponseDTO updateRating(Rating rating){
        Rating updated = ratingRepository.save(rating);
        return new UserRatingResponseDTO(
                updated.getRatingId(),
                updated.getScore(),
                updated.getDescription(),
                updated.getCreatedAt()
        );
    }
}

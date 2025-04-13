package com.ss.restaurant.controller;

import com.ss.restaurant.entity.Rating;
import com.ss.restaurant.requestDTO.rating.RatingRequestDTO;
import com.ss.restaurant.requestDTO.rating.RatingUpdateDTO;
import com.ss.restaurant.responseDTO.RatingResponseDTO;
import com.ss.restaurant.responseDTO.UserRatingResponseDTO;
import com.ss.restaurant.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/restaurants/ratings")
public class RatingController {

    @Autowired
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RatingResponseDTO> getRatingsByRestaurantId(@PathVariable Long restaurantId) {
        RatingResponseDTO ratingResponse = ratingService.getRatingsByRestaurantId(restaurantId);

        if (ratingResponse != null)
            return ResponseEntity.ok(ratingResponse);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{restaurantId}/users/{customerId}")
    public ResponseEntity<UserRatingResponseDTO> getRatingByRestaurantIdAndCustomerId(@PathVariable Long restaurantId, @PathVariable Long customerId) {
        return ratingService.getRatingByRestaurantIdAndCustomerId(restaurantId, customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(new UserRatingResponseDTO()));
    }

    @PostMapping
    public ResponseEntity<UserRatingResponseDTO> submitRating(@RequestBody RatingRequestDTO dto) {
        UserRatingResponseDTO response = ratingService.submitRating(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{ratingId}")
    public ResponseEntity<UserRatingResponseDTO> updateRating(@PathVariable Long ratingId, @RequestBody RatingUpdateDTO dto) {
        Optional<Rating> currentRating = ratingService.getRatingByRatingIdAndRestaurantIdAndCustomerId(ratingId, dto.getRestaurantId(), dto.getCustomerId());

        if(currentRating.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Rating rating = currentRating.get();
        rating.setScore(dto.getScore());
        rating.setDescription(dto.getDescription());

        UserRatingResponseDTO response = ratingService.updateRating(rating);
        return ResponseEntity.ok(response);
    }
}

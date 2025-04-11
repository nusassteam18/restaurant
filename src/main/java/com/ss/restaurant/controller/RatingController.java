package com.ss.restaurant.controller;

import com.ss.restaurant.requestDTO.RatingRequestDTO;
import com.ss.restaurant.responseDTO.RatingResponseDTO;
import com.ss.restaurant.responseDTO.UserRatingResponseDTO;
import com.ss.restaurant.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

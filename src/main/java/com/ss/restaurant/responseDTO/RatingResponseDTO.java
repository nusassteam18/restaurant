package com.ss.restaurant.responseDTO;

import com.ss.restaurant.entity.Rating;

import java.util.List;

public class RatingResponseDTO {
    private Long restaurantId;
    private double averageScore;
    private int rateCount;
    private List<Rating> ratings;

    public RatingResponseDTO(Long restaurantId, double averageScore, int rateCount, List<Rating> ratings) {
        this.restaurantId = restaurantId;
        this.averageScore = averageScore;
        this.rateCount = rateCount;
        this.ratings = ratings;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public double getAverageScore() {
        return averageScore;
    }
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    public int getRateCount() {
        return rateCount;
    }
    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}

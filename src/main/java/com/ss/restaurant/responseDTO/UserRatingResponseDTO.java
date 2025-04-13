package com.ss.restaurant.responseDTO;

import java.util.Date;

public class UserRatingResponseDTO {
    private Long ratingId;
    private double score;
    private String description;
    private Date createdAt;

    public UserRatingResponseDTO() {}

    public UserRatingResponseDTO(Long ratingId, double score, String description, Date createdAt) {
        this.ratingId = ratingId;
        this.score = score;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getRatingId() {
        return ratingId;
    }
    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

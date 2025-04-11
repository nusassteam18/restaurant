package com.ss.restaurant.responseDTO;

import java.util.Date;

public class UserRatingResponseDTO {
    private double score;
    private String description;
    private Date createdAt;

    public UserRatingResponseDTO() {}

    public UserRatingResponseDTO(double score, String description, Date createdAt) {
        this.score = score;
        this.description = description;
        this.createdAt = createdAt;
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

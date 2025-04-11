package com.ss.restaurant.responseDTO;

import com.ss.restaurant.entity.Rating;
import org.apache.catalina.User;

import java.util.Date;
import java.util.List;

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

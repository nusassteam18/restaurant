package com.ss.restaurant.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Rating {
    @Id
    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    @Column(name="rating_id")
    private Long ratingId;
    @Column(name="restaurant_id")
    private Long restaurantId;
    @Column(name="customer_id")
    private Long customerId;
    private double score;

    public Rating() {
    }

    public Rating(Long ratingId, Long customerId, double score) {
        this.ratingId = ratingId;
        this.customerId = customerId;
        this.score = score;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", restaurantId=" + restaurantId +
                ", customerId=" + customerId +
                ", score=" + score +
                '}';
    }
}

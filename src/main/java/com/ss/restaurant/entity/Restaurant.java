package com.ss.restaurant.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Restaurant {
    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )
    @Column(name="restaurant_id")
    private Long restaurantId;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100)
    private String address;
    @Column(length = 20)
    private String contact;
    @Column(length = 200)
    private String description;
    @Column(name="image_id", length = 1000)
    private String imageId;

    // Rounds the average score to 1 decimal place
    // If 2 dps of average score >= 0.05, round up
    // If 2 dps of average score < 0.05, round down
    @Formula("(SELECT ROUND(COALESCE(AVG(r.score), 0), 1) FROM rating r WHERE r.restaurant_id = restaurant_id)")
    private double averageScore;

    @Formula("(SELECT COUNT(r.rating_id) FROM rating r WHERE r.restaurant_id = restaurant_id)")
    private int rateCount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id",
                foreignKey = @ForeignKey(name = "FK_PRODUCT_RESTAURANT_ID",
                        foreignKeyDefinition = "FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id) ON UPDATE CASCADE ON DELETE CASCADE")
    )
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id",
                foreignKey = @ForeignKey(name = "FK_RATING_RESTAURANT_ID",
                                        foreignKeyDefinition = "FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id) ON UPDATE CASCADE ON DELETE CASCADE")
    )
    private List<Rating> ratings = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long restaurantId, String name, String address, String contact, String description, String imageId, List<Product> products, List<Rating> ratings) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.description = description;
        this.imageId = imageId;
        this.products = products;
        this.ratings = ratings;
    }

    public Restaurant(Long restaurantId, String name, String address, String contact, String description, String imageId) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.description = description;
        this.imageId = imageId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", description='" + description + '\'' +
                ", imageId='" + imageId + '\'' +
                ", averageScore='" + averageScore + '\'' +
                ", rateCount='" + rateCount + '\'' +
                ", products=" + products +
//                ", ratings=" + ratings +
                '}';
    }
}

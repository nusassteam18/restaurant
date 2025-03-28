package com.ss.restaurant.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageId;
    private Long restaurantId;

    public ProductDTO() {
    }

    public ProductDTO(Long productId, String name, String description, BigDecimal price, String imageId, Long restaurantId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
        this.restaurantId = restaurantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}

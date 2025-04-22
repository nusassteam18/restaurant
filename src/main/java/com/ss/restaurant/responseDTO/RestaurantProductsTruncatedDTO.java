package com.ss.restaurant.responseDTO;

import java.util.List;

public class RestaurantProductsTruncatedDTO {
    private Long restaurantId;
    private String name;
    private List<ProductTruncatedDTO> productTruncatedDTOS;

    public RestaurantProductsTruncatedDTO() {
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

    public List<ProductTruncatedDTO> getProductTruncatedDTOS() {
        return productTruncatedDTOS;
    }

    public void setProductTruncatedDTOS(List<ProductTruncatedDTO> productTruncatedDTOS) {
        this.productTruncatedDTOS = productTruncatedDTOS;
    }

    @Override
    public String toString() {
        return "RestaurantProductsTruncatedDTO{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", productTruncatedDTOS=" + productTruncatedDTOS +
                '}';
    }
}
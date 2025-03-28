package com.ss.restaurant.dto;

public class RestaurantDTO {
    private Long restaurantId;
    private String name;
    private String description;
    private String address;
    private String contact;
    private String imageId;

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long restaurantId, String name, String description, String address, String email, String imageId) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.address = address;
        this.contact = email;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}

package com.ss.restaurant.entity;

import jakarta.persistence.*;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private List<Product> products = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(Long restaurantId, String name, String address, String contact, String description, String imageId, List<Product> products) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.description = description;
        this.imageId = imageId;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
                ", products=" + products +
                '}';
    }
}

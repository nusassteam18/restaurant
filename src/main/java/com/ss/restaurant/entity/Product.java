package com.ss.restaurant.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name="product_id")
    private Long productId;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 200)
    private String description;
    private BigDecimal price;
    @Column(name="image_id", length = 1000)
    private String imageId;

    public Product() {
    }

    public Product(Long productId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long productId, String name, String description, BigDecimal price, String imageId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}

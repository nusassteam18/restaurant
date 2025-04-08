package com.ss.restaurant.responseDTO;

public class ProductTruncatedDTO {
    private Long productId;
    private String name;

    public ProductTruncatedDTO() {
    }

    public ProductTruncatedDTO(Long productId, String name) {
        this.productId = productId;
        this.name = name;
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

    @Override
    public String toString() {
        return "ProductTruncatedDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                '}';
    }
}

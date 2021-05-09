package com.teodoralashes.shop.dto;

import java.util.List;

public class CreateUserOrderDTO {

    private Long userId;
    private List <Long> productID;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProductID() {
        return productID;
    }

    public void setProductID(List<Long> productID) {
        this.productID = productID;
    }
}

package org.example.service;

public class UserBuy {
    private int userId;
    private int productId;
    private int quantityBuyBeer;
    private String date;

    public UserBuy(int userId, int productId, int quantityBuyBeer, String date) {
        this.userId = userId;
        this.productId = productId;
        this.quantityBuyBeer = quantityBuyBeer;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityBuyBeer() {
        return quantityBuyBeer;
    }

    public void setQuantityBuyBeer(int quantityBuyBeer) {
        this.quantityBuyBeer = quantityBuyBeer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

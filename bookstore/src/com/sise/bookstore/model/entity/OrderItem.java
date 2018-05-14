package com.sise.bookstore.model.entity;

import java.math.BigDecimal;

public class OrderItem {
    private String id;

    private Integer quantity;

    private BigDecimal subtotal;

    private String bookId;

    private String bookName;

    private BigDecimal currPrice;

    private String imageB;

    private String orderId;
    
    private String image_b;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public BigDecimal getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(BigDecimal currPrice) {
        this.currPrice = currPrice;
    }

    public String getImageB() {
        return imageB;
    }

    public void setImageB(String imageB) {
        this.imageB = imageB == null ? null : imageB.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    
    public String getImage_b() {
        return image_b;
    }

    
    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }
}
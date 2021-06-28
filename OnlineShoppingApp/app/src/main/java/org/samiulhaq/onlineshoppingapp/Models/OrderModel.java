package org.samiulhaq.onlineshoppingapp.Models;


public class OrderModel {

    int orderImage;
    String soldItemName;
    String orderPrice;
    String orderNumber;

    public OrderModel(int orderImage, String soldItemName, String orderPrice, String orderNumber) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.orderPrice = orderPrice;
        this.orderNumber = orderNumber;
    }

    public OrderModel() {
        orderImage=0;
        setSoldItemName(null);
        orderPrice=null;
        orderNumber=null;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}



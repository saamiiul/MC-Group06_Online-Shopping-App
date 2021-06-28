package org.samiulhaq.onlineshoppingapp.Models;

public class MainItemsModel {
    int itemImage;
    String itemName;

    public MainItemsModel(int itemImage, String itemName) {
        this.itemImage = itemImage;
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}

package main.java.ru.eltech.cofefe.core.entity;

import javax.persistence.*;


/**
 * Created by destely on 03.11.2014.
 */

public class CartItem {

    private Cofefe cofefe;

    private int quantity = 0;

    public CartItem(Cofefe cofefe) {
        this.cofefe = cofefe;
    }

    public long getId() {
        return cofefe.getId();
    }

    public void setId(long id) {
        cofefe.setId(id);
    }

    public String getImage() {
        return cofefe.getImage();
    }

    public void setImage(String image) {
        cofefe.setImage(image);
    }

    public String getDescription() {
        return cofefe.getDescription();
    }

    public void setDescription(String description) {
        cofefe.setDescription(description);
    }

    public String getTitle() {
        return cofefe.getTitle();
    }

    public void setTitle(String title) {
        cofefe.setTitle(title);
    }

    public String getShortDescription() {
        return cofefe.getShortDescription();
    }

    public void setShortDescription(String shortDescription) {
        cofefe.setShortDescription(shortDescription);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

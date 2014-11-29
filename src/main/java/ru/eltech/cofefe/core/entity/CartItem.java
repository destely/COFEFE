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

    public Cofefe getCofefe() {
        return cofefe;
    }

    public void setCofefe(Cofefe cofefe) {
        this.cofefe = cofefe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

package main.java.ru.eltech.cofefe.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by Юлия on 30.11.2014.
 */
@Embeddable
public class BoughtItem {

    @ManyToOne
    private Cofefe cofefe;

    @Column(name = "quantity")
    private int quantity;

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

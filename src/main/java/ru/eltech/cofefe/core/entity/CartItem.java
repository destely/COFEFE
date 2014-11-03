package main.java.ru.eltech.cofefe.core.entity;

/**
 * Created by destely on 03.11.2014.
 */
public class CartItem {

    private Cofefe cofefe;

    public CartItem(Cofefe cofefe) {
        this.cofefe = cofefe;
    }

    private int quantity = 0;

    public long getId() {
        return cofefe.getId();
    }

    public void setDescription(String description) {
        cofefe.setDescription(description);
    }

    public void setShortDescription(String shortDescription) {
        cofefe.setShortDescription(shortDescription);
    }

    public void setId(long id) {
        cofefe.setId(id);
    }

    public String getImage() {
        return cofefe.getImage();
    }

    public String getDescription() {
        return cofefe.getDescription();
    }

    public String getTitle() {
        return cofefe.getTitle();
    }

    public String getShortDescription() {
        return cofefe.getShortDescription();
    }

    public void setImage(String image) {
        cofefe.setImage(image);
    }

    public void setTitle(String title) {
        cofefe.setTitle(title);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

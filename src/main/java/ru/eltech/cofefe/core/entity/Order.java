package main.java.ru.eltech.cofefe.core.entity;
import javax.persistence.*;
import java.util.*;

/**
 * Created by Юлия on 23.11.2014.
 */

@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.getAll", query = "SELECT c from Order c")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    List<Cofefe> products;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "address")
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cofefe> getOrders() { return products; }

    public void  setOrders(List<Cofefe> orders) { this.products = products; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", products='" + products + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

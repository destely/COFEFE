package main.java.ru.eltech.cofefe.core.entity;
import com.sun.corba.se.spi.ior.ObjectKey;

import javax.persistence.*;
import java.text.DateFormat;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "orders_bought_items", joinColumns = @JoinColumn(name = "id"))
    private List<BoughtItem> products;

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

    public void setProducts(List<BoughtItem> products) { this.products = products; }

    public List<BoughtItem> getProducts(){ return products; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

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

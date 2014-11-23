package main.java.ru.eltech.cofefe.core.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by destely on 03.11.2014.
 */

@Entity
@Table(name = "cofefeUsers")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", length = 32)
    private String login;

    @Column(name = "password", length = 32)
    private String password;

    @ManyToMany
    List<Order> orders;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() { return orders; }

    public void setOrders(List<Order> orders) { this.orders = orders; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", orders='" + orders + '\'' +
                '}';
    }

}

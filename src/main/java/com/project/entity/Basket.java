package com.project.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private long id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BasketItem> items; // Assuming you have a BasketItem entity to represent products in the basket

    // Additional fields, constructors, getters, and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<BasketItem> getItems() {
        return items;
    }

    public void setItems(Set<BasketItem> items) {
        this.items = items;
    }

    // Default constructor
    public Basket() {
        super();
    }
}

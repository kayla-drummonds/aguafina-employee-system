package com.michaeladrummonds.aguafina.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private int quantity;

    @Column
    private double total;

    @Column
    private Date creationDate;

    public OrderDetails() {
    }

    public OrderDetails(Product product, int quantity, double total, Date creationDate) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
        this.creationDate = creationDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", product=" + product + ", quantity=" + quantity + ", total=" + total
                + ", creationDate=" + creationDate + "]";
    }

}

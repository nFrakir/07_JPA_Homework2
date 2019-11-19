package com.gmail.silverleaf.annn.dbobjects;

import javax.persistence.*;

@Entity
@Table (name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private Double price;
    private Double weigth;
    private Boolean is_discount;

    public Dish(String title, Double price, Double weigth, Boolean is_discount) {
        super();
        this.title = title;
        this.price = price;
        this.weigth = weigth;
        this.is_discount = is_discount;
    }

    public Dish() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Boolean getIs_discount() {
        return is_discount;
    }

    public void setIs_discount(Boolean is_discount) {
        this.is_discount = is_discount;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", weigth=" + weigth +
                ", is_discount=" + is_discount +
                '}';
    }
}
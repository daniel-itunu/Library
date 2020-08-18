package com.company.PriorityQueue.Model.Library;

public class Book {
    private String title;
    private Integer quantity;

    public Book(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


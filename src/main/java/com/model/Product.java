package com.model;

public class Product {

    public Product(
        double price, int quantity, String name) {

        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public void addProducts(int quantity) {
        this.quantity +=  quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    public double totalValueInStock() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return  "Name: " + name +
                ", Quantity in Stock: " + quantity +
                ", Price: " + price +
                ", Total Value In Stock: " + totalValueInStock();
    }

    private final double price;

    private int quantity;

    private final String name;

}

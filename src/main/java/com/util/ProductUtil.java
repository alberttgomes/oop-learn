package com.util;

import com.model.Product;

import java.util.Scanner;

public class ProductUtil {

    public static Product addProductQuantity(Product product, Scanner scanner) {
        System.out.print("Enter product quantity to be added in stock: ");

        int quantity = scanner.nextInt();

        product.addProducts(quantity);

        return product;
    }

    public static Product createNewProduct(Scanner scanner) {
        System.out.println("Enter product name: ");

        String name = scanner.nextLine();

        System.out.println("Enter product price: ");

        double price = scanner.nextDouble();

        System.out.println("Enter product quantity: ");

        int quantity = scanner.nextInt();

        Product product = new Product(price, quantity, name);

        System.out.println("\nCreate new product successfully: " + product);

        return product;
    }

    public static Product removeProductQuantity(Product product, Scanner scanner) {
        System.out.print("Enter product quantity to remove: ");

        int quantity = scanner.nextInt();

        product.removeProducts(quantity);

        System.out.println("\nUpdated product data: " + product);

        return product;
    }

}

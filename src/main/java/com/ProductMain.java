package com;

import com.model.Product;
import com.util.ProductUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product product = ProductUtil.createNewProduct(scanner);

        System.out.println(
            """
                Please, pay attention to operation types according:\s
                 \
                (1) remove product's quantity\s
                 \
                (2) add product's quantity\s
                 \
                (3) create a new product\s
                """);

        System.out.println("Enter operation type: ");

        int operation = scanner.nextInt();

        List<Integer> supportedOperations = Arrays.asList(1, 2, 3);

        while(supportedOperations.contains(operation)) {
            product = _process(product, operation, scanner);

            System.out.println("\nUpdated product data: " + product);

            System.out.println("Enter new operation type: ");

            operation = scanner.nextInt();
        }
    }

    private static Product _process(
        Product product, int operation, Scanner scanner) {

        return switch (operation) {
            case 1 -> ProductUtil.removeProductQuantity(product, scanner);
            case 2 -> ProductUtil.addProductQuantity(product, scanner);
            case 3 -> ProductUtil.createNewProduct(scanner);
            default ->
                throw new IllegalArgumentException(
                    "Invalid operation");
        };
    }

}

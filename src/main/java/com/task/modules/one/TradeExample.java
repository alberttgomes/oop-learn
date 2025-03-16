package com.task.modules.one;

import com.task.modules.Example;

import java.util.Locale;
import java.util.Scanner;

public class TradeExample implements Example {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter 1 option to start");

        int option = scanner.nextInt();

        scanner.nextLine();

        while (option == 1) {
            Locale.setDefault(Locale.US);

            doTransaction(scanner);

            System.out.println(
                "enter 1 to continue or anyone option to stop");

            option = scanner.nextInt();

            scanner.nextLine();
        }

        System.out.printf("value to pay %s\n", total);

        double receivedValue = scanner.nextDouble();

        System.out.println("received value " + receivedValue);

        System.out.printf("trade [%s]\n", total -= receivedValue);

        scanner.close();
    }

    private void doTransaction(Scanner scanner) {
        String name = scanner.nextLine();
        double price = scanner.nextDouble();
        int quantity = scanner.nextInt();

        Product product =  new Product(name, price, quantity);

        System.out.printf("unit product name: %s\n", product.name);
        System.out.printf("unit product price: %s\n", product.price);
        System.out.printf("unit product quantity: %s\n", product.quantity);

        total += product.price * product.quantity;

        System.out.printf("\n total price: %s\n", total);
    }

    private double total;

    private record Product(
            String name, double price, int quantity) {

    }

}

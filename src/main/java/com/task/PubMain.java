package com.task;

import com.task.model.Bill;

import java.util.Scanner;

public class PubMain {

    public static void main(String[] args) {
        Bill bill = new Bill();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your gender: ");

        char gender = scanner.next().charAt(0);

        System.out.println("Enter beer quantity: ");

        int beer = scanner.nextInt();

        System.out.println("Enter soft drink quantity: ");

        int softDrink = scanner.nextInt();

        System.out.println("Enter barbecue quantity: ");

        int barbecue = scanner.nextInt();

        bill.setGender(gender);
        bill.setBeer(beer);
        bill.setSoftDrink(softDrink);
        bill.setBarbecue(barbecue);

        _reports(bill);
    }

    private static void _reports(Bill bill) {
        String cover = "Exempt from cover";

        if (bill.cover() > 0.00) {
            cover = String.format("%.2f$", bill.cover());
        }

        System.out.printf(
            """
            Reports:\s
            \t 1. Consume: %.2f$\s
            \t 2. %s\s
            \t 3. Ticket: %.2f$\s
            \t \
            4. Total value to pay: %.2f$""",
            bill.feeding(), cover, bill.ticket(), bill.total());
    }

}

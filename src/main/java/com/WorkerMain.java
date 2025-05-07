package com;

import com.model.Worker;
import com.service.WorkerService;

import java.util.Scanner;

public class WorkerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Worker worker = WorkerService.createWorker(scanner);

        System.out.print("Enter worker hour contracts quantity: ");
        int quantity = scanner.nextInt();

        for (int i = 0; i < quantity; i++) {
            try {
                worker.addContract(WorkerService.readContract(scanner));
            }
            catch (Exception exception) {
                throw new RuntimeException(
                    "Unable to add contracts to worker %s".formatted(
                        worker.getName()), exception);
            }
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YY): ");

        scanner.nextLine();
        String monthAndYear = scanner.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3, 7));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartmentName());
        System.out.printf("Income for: %d years and month %d\n", year, month);
        System.out.printf("%.2f", worker.income(month, year));

    }

}

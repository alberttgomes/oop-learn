package com.service;

import com.model.Department;
import com.model.HourContract;
import com.model.Worker;
import com.model.enums.WorkerLevels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WorkerService {

    public static Worker createWorker(Scanner scanner) {
        System.out.print("Enter Department name: ");
        String departmentName = scanner.nextLine();
        System.out.print("Enter Worker name: ");
        String workerName = scanner.nextLine();
        System.out.print("Choose Worker level: ");
        String workerLevel = scanner.nextLine();
        System.out.print("Enter Worker base salary: ");
        double baseSalary = scanner.nextDouble();

        return new Worker(
            new Department(departmentName), WorkerLevels.valueOf(workerLevel),
            workerName, baseSalary);
    }

    public static HourContract readContract(Scanner scanner) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter hours contract date (yy-MM-dd): ");
        Date contractDate = simpleDateFormat.parse(scanner.next());
        System.out.print("Enter hours contract: ");
        int hours = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter value per hour: ");
        double valuePerHour = scanner.nextDouble();

        HourContract hourContract = new HourContract();

        hourContract.setHours(hours);
        hourContract.setDate(contractDate);
        hourContract.setValuePerContract(valuePerHour);

        return hourContract;
    }

}

package com.task.modules.one;

import com.task.modules.Example;

import java.util.Locale;
import java.util.Scanner;

public class SequentialStructureExample implements Example {

    @Override
    public void execute() {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Writer the width value: ");

        double width = scanner.nextDouble();

        System.out.println("Writer the height value: ");

        double height = scanner.nextDouble();

        System.out.println("Writer the square meter value: ");

        double squareMeterValue = scanner.nextDouble();

        double area = width * height;

        System.out.printf("Area %s\n", area);

        double price = area * squareMeterValue;

        System.out.printf("The price is $ %s \n", price);

    }

}

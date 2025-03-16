package com.task.modules.one;

import com.task.modules.Example;

import java.util.Locale;
import java.util.Scanner;

public class MediaAgeExample implements Example {

    @Override
    public void execute() {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Writer the first name");

        String firstName = scanner.nextLine();

        System.out.println("Writer the first age");

        int firstAge = scanner.nextInt();

        System.out.printf("Writer the second name %s\n", scanner.nextLine());

        String secondName = scanner.nextLine();

        System.out.println("Writer the second age");

        int secondAge = scanner.nextInt();

        double averageAge = (firstAge + secondAge) / 2.0;

        System.out.printf(
            "The average age between [%s] and [%s] is [%s]",
                firstName, secondName, averageAge);
    }

}

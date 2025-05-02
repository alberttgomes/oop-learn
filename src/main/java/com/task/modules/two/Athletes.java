package com.task.modules.two;

import com.task.modules.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Athletes implements Example {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please, enter athletes quantity \n");
        int quantity = scanner.nextInt();

        List<Athlete> athletes = new ArrayList<>(quantity);

        for (int i = 0; i < quantity; i++) {
            athletes.add(_createAthlete(scanner));
        }

        _generateReport(athletes);
    }

    private double _calculateWeightMediumValue(List<Athlete> athletes) {
        double total = 0.0;

        for (Athlete athlete : athletes) {
            total += athlete.weight;
        }

        return total / athletes.size();
    }

    private float _calculateWomanHighValue(List<Athlete> athletes) {
        float total = 0;

        for (Athlete athlete : athletes) {
            if (athlete.sex.equals("f")) {
                total += athlete.high;
            }
        }

        return total / athletes.size();
    }

    private Athlete _createAthlete(Scanner scanner) {
        System.out.println("please, enter the name of the athlete");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("please, enter the sex of the athlete (must be [m/f])");
        String sex = scanner.nextLine();

        while (!_validateSex(sex.charAt(0))) {
            System.out.println("Invalid value! please type either m or f");
            sex = scanner.nextLine();
        }

        System.out.println("please, enter the high of the athlete");

        float high = scanner.nextFloat();

        while (_validateHighAndWeight(high)) {
            System.out.printf(
                "Invalid value! please type a positive number: %s\n", high);

            high = scanner.nextFloat();
        }

        System.out.println("please, enter the weight of the athlete");

        float weight = scanner.nextFloat();

        while (_validateHighAndWeight(weight)) {
            System.out.printf(
                "Invalid value! please type a positive number: %s\n", weight);

            weight = scanner.nextFloat();
        }

        scanner.close();

        return new Athlete(name, sex, high, weight);
    }

    private void _generateReport(List<Athlete> athletes) {
        String manPercent = String.format("%.2f%%", _manPercent(athletes));

        String reportMessage = "Athletes Report \n" +
            "1. Weight medium: " + _calculateWeightMediumValue(athletes) + "\n" +
            "2. Higher: " + _higher(athletes) + "\n" +
            "3. Man percent: " + manPercent + "\n" +
            String.format("4. Higher woman medium: %.2f%n", _calculateWomanHighValue(athletes)) +
            "\tReports finished.";

        System.out.println(reportMessage);
    }

    private String _higher(List<Athlete> athletes) {
        String higherName = "";

        float higher = 0;

        for (Athlete athlete : athletes) {
            if (athlete.high > higher) {
                higher = athlete.high;
                higherName = athlete.name;
            }
        }

        return higherName;
    }

    private double _manPercent(List<Athlete> athletes) {
        double manPercent = 0.0;

        for (Athlete athlete : athletes) {
            if (athlete.sex.equals("m")) {
                manPercent++;
            }
        }

        return manPercent / athletes.size() * 100;
    }

    private boolean _validateHighAndWeight(float value) {
        return value <= 0;
    }

    private boolean _validateSex(char sex) throws IllegalArgumentException {
        return sex == 'm' || sex == 'f';
    }

    private record Athlete(
        String name, String sex, float high, float weight) {

        @Override
        public String toString() {
            return String.format(
                "name: %s, sex: %s, high: %s, weight: %s", name, sex, high, weight);
        }

    }

}

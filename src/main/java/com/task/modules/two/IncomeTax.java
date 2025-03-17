package com.task.modules.two;

import com.task.modules.Example;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IncomeTax implements Example {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter your name");

        String name = scanner.nextLine();

        System.out.println("please, enter your salary amounts: ");

        double salary = scanner.nextDouble();

        System.out.println("please, enter your salary with provision service: ");

        double provisionServiceAmounts = scanner.nextDouble();

        System.out.println("please, enter your capital gain: ");

        double capitalGainAmounts = scanner.nextDouble();

        System.out.println("please, enter your medical expenses: ");

        double medicalExpensesAmounts = scanner.nextDouble();

        System.out.println("please, enter your educational expenses: ");

        double educationalExpensesAmounts = scanner.nextDouble();

        Amounts amounts = new Amounts(
            salary, capitalGainAmounts, provisionServiceAmounts,
            medicalExpensesAmounts, educationalExpensesAmounts);

        Map<String, Tax> mapTaxMap = _applyIncomeTax(amounts);

        System.out.printf(
            "\nsummary Income Tax year %s belong to %s\n", Date.from(Instant.now()), name);

        Tax taxAmounts = mapTaxMap.get("tax-amounts");

        System.out.println("tax about salary: " + taxAmounts.taxAboutSalary);
        System.out.println("tax about capital gain: " + taxAmounts.taxAboutCapitalGain);
        System.out.println("tax about provision service: " + taxAmounts.taxAboutProvisionServices());

        System.out.println("\ndeduction: ");

        System.out.println("max deduction: " + taxAmounts.reduction);
        System.out.printf("spend deductions: %s\n", amounts.spend());

        System.out.println("\nresume: ");

        double taxDue = taxAmounts.totalTax();
        double reduction = taxAmounts.reduction;

        System.out.println("tax total: " + taxAmounts.totalTax());
        System.out.println("reduction: " + taxAmounts.reduction);
        System.out.printf("tax due: %s\n", taxDue - reduction);
    }

    private Map<String, Tax> _applyIncomeTax(Amounts amounts) {
        Map<String, Tax> incomeTaxMap = new HashMap<>();

        double salaryAmount = amounts.amount / 12;

        double taxSalaryAmounts = 0.0;

        if (salaryAmount > 3000.00 && salaryAmount <= 5000.00) {
            taxSalaryAmounts = amounts.amount / 100 * 10;
        }
        else if (salaryAmount > 5000.00) {
            taxSalaryAmounts = amounts.amount / 100 * 20;
        }

        double psAmount = amounts.provisionServicesAmount / 100 * 15;

        double cgAmount = amounts.capitalGain / 100 * 20;

        double expensesAmounts = amounts.educationalExpenses + amounts.medicalExpenses;

        double reductionAmount = 0.0;

        double taxAmounts = taxSalaryAmounts + cgAmount + psAmount;

        double taxPercent = taxAmounts / 100 * 30;

        if (expensesAmounts < taxPercent) {
            reductionAmount = expensesAmounts;
        }
        else if (expensesAmounts > taxAmounts) {
            reductionAmount = taxAmounts / 100 * 30;
        }

        System.out.printf(
            "update amounts: %s\n", amounts.taxPay(taxSalaryAmounts, cgAmount, psAmount));

        incomeTaxMap.put(
            "tax-amounts", new Tax(taxSalaryAmounts, psAmount, cgAmount, reductionAmount));

        return incomeTaxMap;
    }

    private record Amounts(
        double amount, double capitalGain, double provisionServicesAmount,
        double medicalExpenses, double educationalExpenses) {

        public double spend() {
            return medicalExpenses + educationalExpenses;
        }

        public Amounts taxPay(double taxAmount, double taxCG, double taxPS) {
            if (taxAmount <= amount) {
                return new Amounts(
                    amount - taxAmount, capitalGain - taxCG,
                    provisionServicesAmount - taxPS,
                    medicalExpenses, educationalExpenses);
            }

            return this;
        }

    }

    private record Tax(
        double taxAboutSalary, double taxAboutProvisionServices, double taxAboutCapitalGain,
        double reduction) {

        public double totalTax() {
            return taxAboutSalary + taxAboutProvisionServices + taxAboutCapitalGain;
        }

    }

}

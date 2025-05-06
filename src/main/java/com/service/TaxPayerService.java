package com.service;

import com.model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TaxPayerService {

    public static List<TaxPayer> collectTaxPayers() {
        System.out.println("Enter the number of tax payers you want to sell: ");

        Scanner scanner = new Scanner(System.in);
        int numberOfTaxPayers = scanner.nextInt();
        scanner.nextLine();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 0; i < numberOfTaxPayers; i++) {
            System.out.println("Enter the tax payer data: ");
            taxPayers.add(_readTaxPayerAmount(scanner));
        }

        return taxPayers;
    }

    public static void taxPayersResume(List<TaxPayer> taxPayerList) {
        int index = 0;

        for (TaxPayer taxPayer : taxPayerList) {
            if (Objects.nonNull(taxPayer)) {
                double grossTax = taxPayer.grossTax();
                double netTax = taxPayer.netTax();
                double rebate = taxPayer.taxRebate();

                index++;

                String string =
                    "Tax Payer Resume #" + index + " : " +
                    "\n" +
                    "Total Gross Tax: " + String.format("%.2f", grossTax) +
                    "\n" +
                    "Rebate Tax: " + String.format("%.2f", rebate) +
                    "\n" +
                    "Net Tax: " + String.format("%.2f", netTax);

                System.out.print("\n\n" + string);
            }
        }
    }

    private static TaxPayer _readTaxPayerAmount(Scanner scanner) {
        System.out.print("Enter annual income: ");
        double annualIncome = scanner.nextDouble();
        System.out.print("Enter annual service income: ");
        double annualServiceIncome = scanner.nextDouble();
        System.out.print("Enter capital gain amount: ");
        double capitalGainAmount = scanner.nextDouble();
        System.out.print("Enter annual expense health: ");
        double annualExpenseHealth = scanner.nextDouble();
        System.out.print("Enter annual expense education: ");
        double annualExpenseEducation = scanner.nextDouble();

        return new TaxPayer(
            capitalGainAmount, annualExpenseEducation, annualExpenseHealth,
            annualIncome, annualServiceIncome);
    }

}

package com.model;

public class TaxPayer {

    public TaxPayer(
        double capitalIncome, double educationSpend, double healthSpend, double salaryIncome,
        double servicesIncome) {

        this.capitalIncome = capitalIncome;
        this.educationSpend = educationSpend;
        this.healthSpend = healthSpend;
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
    }

    public Double capitalTax() {
        return capitalIncome / 100 * 20;
    }

    public Double grossTax() {
        return capitalTax() + salaryTax() + serviceTax();
    }

    public Double salaryTax() {
        double salaryAmount = salaryIncome / 12;

        double taxSalaryAmount = 0.0;

        if (salaryAmount > 3000.00 && salaryAmount <= 5000.00) {
            taxSalaryAmount = salaryIncome / 100 * 10;
        }
        else if (salaryAmount > 5000.00) {
            taxSalaryAmount = salaryIncome / 100 * 20;
        }

        return taxSalaryAmount;
    }

    public Double serviceTax() {
        return servicesIncome / 100 * 15;
    }

    public Double netTax() {
        return grossTax() - taxRebate();
    }

    public Double taxRebate() {
        double maxRebateAmount = grossTax() / 100 * 30;
        double expensesAmount = educationSpend + healthSpend;

        return Math.min(expensesAmount, maxRebateAmount);
    }

    private final Double capitalIncome;

    private final Double educationSpend;

    private final Double healthSpend;

    private final Double salaryIncome;

    private final Double servicesIncome;

}

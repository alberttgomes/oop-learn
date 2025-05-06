package com;

import com.model.TaxPayer;
import com.service.TaxPayerService;

import java.util.List;

public class TaxPayerMain {

    public static void main(String[] args) {
        System.out.println("Initializing TaxPayer System...");

        List<TaxPayer> taxPayers = TaxPayerService.collectTaxPayers();

        TaxPayerService.taxPayersResume(taxPayers);
    }

}

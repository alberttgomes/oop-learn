package com.sales.analytics.service;

import com.sales.analytics.model.Sale;

import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class SaleService {

    public static void scannerSale(List<Sale> sales) {
        System.out.println("\nTop five sales of 2016 with the highest average price");

        _olderSalesMostExpensive(sales).forEach(System.out::println);

        System.out.printf(
            "\nTotal value sell by logan seller on months 1 and 7 %.2f \n",
            _totalLoganSeller(sales));
    }

    private static List<Sale> _olderSalesMostExpensive(List<Sale> sales) {
        return sales.stream()
            .filter(sale -> sale.getYear() == 2016)
            .sorted((s1, s2) -> Double.compare(s2.averagePrice(), s1.averagePrice()))
            .limit(_LIMIT)
            .toList();
    }

    private static Double _totalLoganSeller(List<Sale> sales) {
        List<Sale> filtered =  sales.stream()
            .filter(sale -> sale.getSeller().equals("Logan"))
            .filter(sale -> sale.getMonth() == 1 || sale.getMonth() == 7)
            .toList();

        Double total = 0.0;

        for (Sale sale : filtered) {
            total += sale.getTotal();
        }

        return total;
    }

    private static final int _LIMIT = 5;

}

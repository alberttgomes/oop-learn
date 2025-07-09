package com.sales.analytics.builder;

import com.sales.analytics.model.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class SaleBuilder {

    public void build(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] contentArray = line.split(",");

                Integer month = Integer.valueOf(contentArray[0]);
                Integer year = Integer.valueOf(contentArray[1]);
                String seller = contentArray[2];
                Integer items = Integer.valueOf(contentArray[3]);
                Double total = Double.valueOf(contentArray[4]);

                SALES.add(new Sale(items, month, seller, total, year));
            }
        }
        catch (IOException e) {
            throw new RuntimeException(
                "The system cannot find the file specified");
        }
    }

    public final List<Sale> SALES = new ArrayList<>();

}

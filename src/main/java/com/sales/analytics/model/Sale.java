package com.sales.analytics.model;

/**
 * @author Albert Gomes Cabral
 */
public class Sale {

    public Sale(
        Integer items, Integer month, String seller, Double total,
        Integer year) {

        this.items = items;
        this.month = month;
        this.seller = seller;
        this.total = total;
        this.year = year;
    }

    public Double averagePrice() {
        return this.total / this.items;
    }

    public Integer getMonth() {
        return month;
    }

    public String getSeller() {
        return seller;
    }

    public Integer getYear() {
        return year;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return String.format(
            "%s/%s, %s, %s, %s, pm = %.2f",
            month, year, seller, items, total, this.averagePrice());
    }

    private final Integer items;
    private final Integer month;
    private final String seller;
    private final Double total;
    private final Integer year;

}

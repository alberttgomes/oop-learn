package com.model;

import java.util.Date;

public class HourContract {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setValuePerContract(Double valuePerContract) {
        this.valuePerContract = valuePerContract;
    }

    public double totalValue() {
        return valuePerContract * hours;
    }

    private Date date;
    private Integer hours;
    private Double valuePerContract;

}

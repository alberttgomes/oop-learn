package com.task.model;

/**
 * @author Albert Gomes Cabral
 */
public class Bill {

    public void setBarbecue(int barbecue) {
        this._barbecue = barbecue;
    }

    public void setBeer(int beer) {
        this._beer = beer;
    }

    public void setGender(char gender) {
        this._gender = gender;
    }

    public void setSoftDrink(int softDrink) {
        this._softDrink = softDrink;
    }

    public double cover() {
        if (feeding() < 30) {
            return 4.00;
        }

        return 0.00;
    }

    public double feeding() {
        return ((_barbecue * 7.00) + (_beer * 5.00) + (_softDrink * 3.00));
    }

    public double ticket() {
        return _gender == 'f' ? 8.00 : 10.00;
    }

    public double total() {
        double total = 0.00;

        total += cover();

        total += feeding();

        total += ticket();

        return total;
    }

    private char _gender;

    private int _beer;

    private int _barbecue;

    private int _softDrink;

}

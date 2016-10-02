package com.hibernate.mapping;

/**
 * Created by Kiranmai on 10/1/16.
 */
public class Toyota extends Vehicle{

    private String model;
    private String year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

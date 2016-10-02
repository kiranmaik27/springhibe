package com.hibernate.mapping;

/**
 * Created by Kiranmai on 10/1/16.
 */
public class Vehicle {

    private Long id;
    private String vin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}

package com.quantityymeasurement.demo.model;


import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Unit {
    private String value;
    private String[]  listOfLengths;

    public Unit(String value, String[] listOfLengths) {
        this.value = value;
        this.listOfLengths = listOfLengths;
    }

    public Unit() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getListOfLengths() {
        return listOfLengths;
    }

    public void setListOfLengths(String[] listOfLengths) {
        this.listOfLengths = listOfLengths;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "value=" + value +
                ", listOfLengths=" + listOfLengths +
                '}';
    }
}

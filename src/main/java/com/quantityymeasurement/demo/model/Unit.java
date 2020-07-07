package com.quantityymeasurement.demo.model;


import org.springframework.stereotype.Repository;

@Repository
public class Unit {
    private String value;
    private String[] listOfUnits;

    public Unit(String value) {
        this.value = value;
    }

    public String[] getListOfUnits() {
        return listOfUnits;
    }

    public void setListOfUnits(String[] listOfUnits) {
        this.listOfUnits = listOfUnits;
    }

    public Unit(String value, String[] listOfUnits) {
        this.value = value;
        this.listOfUnits = listOfUnits;
    }

    public Unit() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "value=" + value +
                '}';
    }
}

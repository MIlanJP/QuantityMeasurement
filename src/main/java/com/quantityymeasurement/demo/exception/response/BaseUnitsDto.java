package com.quantityymeasurement.demo.exception.response;

import java.util.*;

public class BaseUnitsDto {
    public String units;
    public List listOfUnits;
    public int status;

    public BaseUnitsDto(String units, List listOfUnits, int status) {
        this.units = units;
        this.listOfUnits = listOfUnits;
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public List getListOfUnits() {
        return listOfUnits;
    }

    public void setListOfUnits(List listOfUnits) {
        this.listOfUnits = listOfUnits;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package com.measurements;

import java.util.Objects;

public class QuantityMeasurement {
    private int CONVERTFOOTTOINCH =12 ;
    private double length;

    public QuantityMeasurement(Unit unit, Double length) {
        if(unit.equals(Unit.INCH))
            this.length=length;
        else if(unit.equals(Unit.FOOT))
            this.length=length*CONVERTFOOTTOINCH;
    }

    public boolean compareLengths(double foot, double inch) {
        return foot*CONVERTFOOTTOINCH==inch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.length, length) == 0;
    }

    public QuantityMeasurement() {
    }
}

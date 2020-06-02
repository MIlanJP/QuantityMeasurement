package com.measurements;

import java.util.Objects;

public class QuantityMeasurement {

    private double length;

    public QuantityMeasurement(Unit unit, Double length) throws UnitLengthException {
        if(length==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }else{
            this.length=unit.getValue()*length;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.length, length) == 0;
    }

}

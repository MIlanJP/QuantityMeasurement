package com.measurements;

import java.text.DecimalFormat;

public class LengthMeasurement {

    private double length;

    public LengthMeasurement(Unit unit, Double length) throws UnitLengthException {
        if(length==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
        this.length=unit.getValue()*length;
    }

    public LengthMeasurement() {
    }

    public double returnAs(Unit unitin , Double length, Unit unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.length=unitin.getValue()*length;
        return (this.length/unitout.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LengthMeasurement)) return false;
        LengthMeasurement that = (LengthMeasurement) o;
        return Double.compare(that.length, length) == 0;
    }

}

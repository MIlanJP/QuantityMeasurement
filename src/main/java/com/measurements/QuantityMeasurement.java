package com.measurements;

import java.util.Arrays;
import java.util.List;

public class QuantityMeasurement {

    private double quantity;
    private Units units;

    public QuantityMeasurement() {}

    public QuantityMeasurement(Units units, Double quantity)  {
        if(units.getValue()[0]!="TEMPERATURE")
            this.quantity =(Double)units.getValue()[1]*quantity;
        else if(units.getValue()[0]=="TEMPERATURE"){
            if(units==Units.FAHRENHIET)
                this.quantity =(quantity -(Double)units.getValue()[1])*(1.00/(Double)units.getValue()[2]);
       else if(units==Units.KELVIN)
            this.quantity = quantity -(Double)units.getValue()[1];
       else
           this.quantity = quantity;
        }
        this.units=units;

    }

    public double convert(Units unitin , Double quantity, Units unitout) throws UnitLengthException {
        List unitValuesIn = Arrays.asList(unitin.getValue());
        List unitValuesOut = Arrays.asList(unitout.getValue());
        if(unitValuesIn.get(0)==unitValuesOut.get(0)){
            throw new UnitLengthException("Invalid conversion"
                    ,UnitLengthException.ExceptionType.INVALID_CONVERSION);
        }
        if(quantity==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        if(unitin==Units.FAHRENHIET)
            this.quantity= (quantity-(Double)unitin.getValue()[2])*(1.0/(Double)unitin.getValue()[1]);
        else if(units==Units.KELVIN)
            this.quantity=  quantity-(Double)unitin.getValue()[1];
        else if(units==Units.CELCIUS)
            this.quantity =quantity;
        if(unitout==Units.KELVIN)
            return this.quantity+(Double)unitin.getValue()[1];
        else if(unitout==Units.FAHRENHIET)
            return (this.quantity+(Double)unitout.getValue()[1])+(Double)unitin.getValue()[2];
        else if(unitout==Units.CELCIUS)
            return this.quantity;

        this.quantity =(Double)unitValuesIn.get(1)*quantity;

        return Math.round(this.quantity /(Double)unitValuesOut.get(1)*100.0)/100.0;
    }

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            if(measurement.units.getValue()[0]!=requiredUnit.getValue()[0])
                throw new UnitLengthException("Invalid Unit Conversion"
                        ,UnitLengthException.ExceptionType.INVALID_CONVERSION);
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurement(requiredUnit,Math.round(totalLength/(Double)requiredUnit.getValue()[1] * 100.0) / 100.);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.quantity, quantity) == 0;
    }

}

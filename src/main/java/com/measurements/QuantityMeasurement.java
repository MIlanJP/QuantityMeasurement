package com.measurements;

import java.util.Arrays;
import java.util.List;

public class QuantityMeasurement {

    private double quantity;
    private Units units;

    public QuantityMeasurement() {}

    public QuantityMeasurement(Units units, Double quantity) throws UnitLengthException {
        //List unitValues = Arrays.asList(units.getValue());
        if(units.getValue()[0]!="TEMPERATURE")
            this.quantity =(Double)units.getValue()[1]*quantity;
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

    //    public QuantityMeasurement(Units.TemperatureUnits tempUnits, Double quantity) throws UnitLengthException {
//        if(quantity ==null){
//            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
//        }
//       if(tempUnits==Units.TemperatureUnits.FAHRENHIET)
//           this.quantity =(quantity -tempUnits.getFirstValue())*(1.00/tempUnits.getSecondValue());
//       else if(tempUnits==Units.TemperatureUnits.KELVIN)
//            this.quantity = quantity -tempUnits.getFirstValue();
//       else
//           this.quantity = quantity;
//       this.temperatureValues=tempUnits;
//    }


//    public double convert(Units.TemperatureUnits unitin , Double degree, Units.TemperatureUnits unitout) throws UnitLengthException {
//        if(degree==null||unitout==null||unitin==null)
//            throw new UnitLengthException("null value entered"
//                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
//        //Conversion To Celcius
//        if(unitin==Units.TemperatureUnits.FAHRENHIET)
//            this.quantity =(degree -(unitin.getFirstValue()))*unitin.getSecondValue();
//        else if(unitin==Units.TemperatureUnits.KELVIN)
//            this.quantity =(quantity -unitin.getFirstValue());
//        else
//            this.quantity =degree;
//        //Output in Required Unit
//        if(unitout==Units.TemperatureUnits.FAHRENHIET)
//            return (this.quantity *unitout.getFirstValue())+unitout.getSecondValue();
//        else if(unitout==Units.TemperatureUnits.KELVIN)
//            return (this.quantity +unitout.getFirstValue());
//        return this.quantity;
//    }

//    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units.TemperatureUnits requiredUnit) throws UnitLengthException {
//        double totalLength=0;
//        for(QuantityMeasurement measurement:lengths){
//            totalLength+=measurement.quantity;
//        }
//        if(requiredUnit==Units.TemperatureUnits.FAHRENHIET)
//            return new QuantityMeasurement(requiredUnit,
//                    Math.round(((this.quantity *(requiredUnit.getSecondValue()))+requiredUnit.getSecondValue())*100.0)/100.0);
//        else if(requiredUnit==Units.TemperatureUnits.KELVIN){
//            return new QuantityMeasurement(requiredUnit,
//                    Math.round(((this.quantity *requiredUnit.getFirstValue())+requiredUnit.getSecondValue())*100.0)/100.0);
//        }
//        return new QuantityMeasurement(requiredUnit,this.quantity);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.quantity, quantity) == 0;
    }

}

package com.measurements;

import java.util.List;
import java.util.Map;

public class QuantityMeasurement {

    private double quantity;
    private LengthUnits lengthUnit;

    public QuantityMeasurement() {
    }

    public QuantityMeasurement(LengthUnits lengthUnits, Double quantity) throws UnitLengthException {
     //   this.convert(lengthUnits,quantity);
        if(quantity ==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
        this.quantity = lengthUnits.getValue()* quantity;
        this.lengthUnit = lengthUnits;
    }

//    public QuantityMeasurement(TemperatureUnits tempUnits, Double quantity) throws UnitLengthException {
//        if(quantity ==null){
//            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
//        }
//       if(tempUnits==TemperatureUnits.FAHRENHIET)
//           this.quantity =(quantity *tempUnits.getFirstValue())+tempUnits.getSecondValue();
//       else if(tempUnits==TemperatureUnits.KELVIN)
//            this.quantity = quantity -tempUnits.getFirstValue();
//       else
//           this.quantity = quantity;
//    }

    public double convert(LengthUnits unitin , Double length, LengthUnits unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getValue()*length;
        return (this.quantity /unitout.getValue());
    }

//    public double convert(TemperatureUnits unitin , Double degree, TemperatureUnits unitout) throws UnitLengthException {
//        if(degree==null||unitout==null||unitin==null)
//            throw new UnitLengthException("null value entered"
//                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
//        //Conversion To Celcius
//        if(unitin==TemperatureUnits.FAHRENHIET)
//            this.quantity =(quantity *(9/5))+32;
//        else if(unitin==TemperatureUnits.KELVIN)
//            this.quantity =(quantity -unitin.getFirstValue());
//        else
//            this.quantity =degree;
//        //Output in Required Unit
//        if(unitout==TemperatureUnits.FAHRENHIET)
//            return (this.quantity -unitout.getFirstValue())*unitout.getSecondValue();
//        else if(unitout==TemperatureUnits.KELVIN)
//            return (this.quantity +unitout.getFirstValue());
//        return this.quantity;
//    }

//    public double convert(LengthUnits lengthUnits, Double quantity) throws UnitLengthException {
//
//    }

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, LengthUnits requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurement(requiredUnit,Math.round(totalLength/requiredUnit.getValue() * 100.0) / 100.);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.quantity, quantity) == 0;
    }



}

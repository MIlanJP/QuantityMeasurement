package com.measurements;

import java.util.List;

public class QuantityMeasurement {

    private double quantity;
    private Units.LengthUnits lengthValues;
    private Units.VolumeUnits volumeValues;
    private Units.WeightUnits weightvalues;

    public QuantityMeasurement() {}

    public QuantityMeasurement(Units.LengthUnits lengthUnits, Double quantity) throws UnitLengthException {
        if(quantity ==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
        this.quantity = lengthUnits.getLengthValue()* quantity;
        this.lengthValues = lengthUnits;
    }

    public QuantityMeasurement(Units.VolumeUnits volumeUnits, Double quantity) throws UnitLengthException {
        if(quantity ==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
        this.quantity = volumeUnits.getVolumeValue()* quantity;
        this.volumeValues = volumeUnits;
    }

    public QuantityMeasurement(Units.WeightUnits weightUnits, Double quantity) throws UnitLengthException {
        if(quantity ==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
        this.quantity = weightUnits.getWeightValue()* quantity;
        this.weightvalues = weightUnits;
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

    public double convert(Units.LengthUnits unitin , Double length, Units.LengthUnits unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getLengthValue()*length;
        return Math.round(this.quantity /unitout.getLengthValue()*100.0)/100.0;
    }

    public double convert(Units.VolumeUnits unitin , Double length, Units.VolumeUnits unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getVolumeValue()*length;
        return Math.round(this.quantity /unitout.getVolumeValue()*100.0)/100.0;
    }

    public double convert(Units.WeightUnits unitin , Double length, Units.WeightUnits unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getWeightValue()*length;
        return Math.round(this.quantity /unitout.getWeightValue()*100.0)/100.0;
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

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units.LengthUnits requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurement(requiredUnit,Math.round(totalLength/requiredUnit.getLengthValue() * 100.0) / 100.);
    }

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units.VolumeUnits requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurement(requiredUnit,Math.round(totalLength/requiredUnit.getVolumeValue() * 100.0) / 100.);
    }

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units.WeightUnits requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurement(requiredUnit,Math.round(totalLength/requiredUnit.getWeightValue() * 100.0) / 100.);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.quantity, quantity) == 0;
    }



}

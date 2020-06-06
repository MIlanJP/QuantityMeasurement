package com.measurements;

import java.util.List;

public class QuantityMeasurement {

    private double quantity;
    private Units.LengthUnits lengthValues;
    private Units.VolumeUnits volumeValues;
    private Units.WeightUnits weightvalues;
    private Units.TemperatureUnits temperatureValues;

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

    public QuantityMeasurement(Units.TemperatureUnits tempUnits, Double quantity) throws UnitLengthException {
        if(quantity ==null){
            throw new UnitLengthException("null value supplied",UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        }
       if(tempUnits==Units.TemperatureUnits.FAHRENHIET)
           this.quantity =(quantity -tempUnits.getFirstValue())*(1.00/tempUnits.getSecondValue());
       else if(tempUnits==Units.TemperatureUnits.KELVIN)
            this.quantity = quantity -tempUnits.getFirstValue();
       else
           this.quantity = quantity;
       this.temperatureValues=tempUnits;
    }

    public double convert(Units.LengthUnits unitin , Double length, Units.LengthUnits unitout) throws UnitLengthException {
        if(length==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getLengthValue()*length;
        return Math.round(this.quantity /unitout.getLengthValue()*100.0)/100.0;
    }

    public double convert(Units.VolumeUnits unitin , Double volume, Units.VolumeUnits unitout) throws UnitLengthException {
        if(volume==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getVolumeValue()*volume;
        return Math.round(this.quantity /unitout.getVolumeValue()*100.0)/100.0;
    }

    public double convert(Units.WeightUnits unitin , Double weight, Units.WeightUnits unitout) throws UnitLengthException {
        if(weight==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =unitin.getWeightValue()*weight;
        return Math.round(this.quantity /unitout.getWeightValue()*100.0)/100.0;
    }

    public double convert(Units.TemperatureUnits unitin , Double degree, Units.TemperatureUnits unitout) throws UnitLengthException {
        if(degree==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        //Conversion To Celcius
        if(unitin==Units.TemperatureUnits.FAHRENHIET)
            this.quantity =(degree -(unitin.getFirstValue()))*unitin.getSecondValue();
        else if(unitin==Units.TemperatureUnits.KELVIN)
            this.quantity =(quantity -unitin.getFirstValue());
        else
            this.quantity =degree;
        //Output in Required Unit
        if(unitout==Units.TemperatureUnits.FAHRENHIET)
            return (this.quantity *unitout.getFirstValue())+unitout.getSecondValue();
        else if(unitout==Units.TemperatureUnits.KELVIN)
            return (this.quantity +unitout.getFirstValue());
        return this.quantity;
    }

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

    public QuantityMeasurement add(List<QuantityMeasurement> lengths, Units.TemperatureUnits requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurement measurement:lengths){
            totalLength+=measurement.quantity;
        }
        if(requiredUnit==Units.TemperatureUnits.FAHRENHIET)
            return new QuantityMeasurement(requiredUnit,
                    Math.round(((this.quantity *(requiredUnit.getSecondValue()))+requiredUnit.getSecondValue())*100.0)/100.0);
        else if(requiredUnit==Units.TemperatureUnits.KELVIN){
            return new QuantityMeasurement(requiredUnit,
                    Math.round(((this.quantity *requiredUnit.getFirstValue())+requiredUnit.getSecondValue())*100.0)/100.0);
        }
        return new QuantityMeasurement(requiredUnit,this.quantity);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurement)) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        return Double.compare(that.quantity, quantity) == 0;
    }

}

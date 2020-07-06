package com.quantityymeasurement.demo.service;

import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementService {

    private double quantity;
    private Units units;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public QuantityMeasurementService() {}

    public QuantityMeasurementService(Units units, Double quantity)  {
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
        if(unitin.getValue()[0]!=unitout.getValue()[0]){
            throw new UnitLengthException("Invalid conversion"
                    ,UnitLengthException.ExceptionType.INVALID_CONVERSION);
        }
        if(quantity==null||unitout==null||unitin==null)
            throw new UnitLengthException("null value entered"
                    ,UnitLengthException.ExceptionType.NULLVALUESUPPLIED);
        this.quantity =(Double)unitin.getValue()[1]*quantity;
        return Math.round(this.quantity /(Double)unitout.getValue()[1]*100.0)/100.0;
    }

    public QuantityMeasurementService add(List<QuantityMeasurementService> lengths, Units requiredUnit) throws UnitLengthException {
        double totalLength=0;
        for(QuantityMeasurementService measurement:lengths){
            if(measurement.units.getValue()[0]!=requiredUnit.getValue()[0])
                throw new UnitLengthException("Invalid Unit Conversion"
                        ,UnitLengthException.ExceptionType.INVALID_CONVERSION);
            totalLength+=measurement.quantity;
        }
        return new QuantityMeasurementService(requiredUnit,Math.round(totalLength/(Double)requiredUnit.getValue()[1] * 100.0) / 100.);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurementService)) return false;
        QuantityMeasurementService that = (QuantityMeasurementService) o;
        return Double.compare(that.quantity, quantity) == 0;
    }

}

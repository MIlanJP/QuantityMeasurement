package com.quantityymeasurement.demo.controller;

import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.QuantityMeasurementResponseException;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quantitymeasurement")
public class QuantityMeasurementController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuantityMeasurementService quantityMeasurementService;

    Unit unit;

    @GetMapping("/sum/{values}/unit/{requiredunit}")
    public Unit addLength(@PathVariable String values, @PathVariable String requiredunit) throws UnitLengthException {
        List<QuantityMeasurementService> listOfUnits=new ArrayList<QuantityMeasurementService>();
        String[] splitvalues=values.split(",");
        for(String value:splitvalues){
            String[] splitargs=value.split(":");
            listOfUnits.add(new QuantityMeasurementService(Units.valueOf(splitargs[0].toUpperCase()),
                    Double.parseDouble(splitargs[1])+0.00));
        }
        QuantityMeasurementService value=quantityMeasurementService.add(listOfUnits,
                Units.valueOf(requiredunit.toUpperCase()));
        unit=new Unit(String.valueOf(value.getUnits())+" "+String.valueOf(value.getQuantity()/
                (Double) Units.valueOf(requiredunit.toUpperCase()).getValue()[1]), splitvalues);
        System.out.println(unit+"Printing from contorller");
        return unit;
    }

    @PostMapping("/sum")
    public Unit addLengthFromPostMethod(@RequestBody Unit unit) throws UnitLengthException {
        List<QuantityMeasurementService> listOfUnits=new ArrayList<QuantityMeasurementService>();
        for(String value:unit.getListOfUnits()){
            String[] splitargs=value.split(":");
            System.out.println(value);
            listOfUnits.add(new QuantityMeasurementService(Units.valueOf(splitargs[0].toUpperCase()),
                    Double.parseDouble(splitargs[1])+.00));
        }
      try{  double relation= (double) Units.valueOf(unit.getValue().toUpperCase()).getValue()[1];
        QuantityMeasurementService value=quantityMeasurementService.add(listOfUnits,
                Units.valueOf(unit.getValue().toUpperCase()));
        System.out.println(unit.getValue().toUpperCase()+"Printing required unit");
        unit.setValue(value.getUnits()+" "+String.valueOf(value.getQuantity()
                /(Double)Units.valueOf(unit.getValue().toUpperCase()).getValue()[1]));
        System.out.println(unit+"Printing from post method");
      }catch (IllegalArgumentException|UnitLengthException e){
        throw new QuantityMeasurementResponseException("wrong unit entered");
      }
        return unit;
    }

    @GetMapping("/convert/{unitIn}/{value}/{unitOut}")
    public String convertUnit(@PathVariable String unitIn,@PathVariable String unitOut ,@PathVariable double value) throws UnitLengthException {
        Double result=null;
        Units unitin=Units.valueOf(unitIn.toUpperCase());
        Units unitout=Units.valueOf(unitOut.toUpperCase());
        String[] splitUnitAndValue=unitIn.split(":");
       try {
             result=quantityMeasurementService.convert(unitin
                   ,value+0.0,
                     unitout);
       }catch(UnitLengthException e){
           throw new QuantityMeasurementResponseException("Invalid Unit conversion");
       }
        logger.info("{}",result);
        return String.valueOf(result);
    }



}

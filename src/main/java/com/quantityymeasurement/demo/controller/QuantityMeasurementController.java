package com.quantityymeasurement.demo.controller;

import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quantitymeasurement")
public class QuantityMeasurementController {

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
                    Double.parseDouble(splitargs[1]+".00")));
        }
        QuantityMeasurementService value=quantityMeasurementService.add(listOfUnits,
                Units.valueOf(requiredunit.toUpperCase()));
        unit=new Unit(value.getUnits()+" "+String.valueOf(value.getQuantity()), splitvalues);
        System.out.println(unit);
        return unit;
    }

}

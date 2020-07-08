package com.quantityymeasurement.demo.controller;

import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.QuantityMeasurementResponseException;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.model.UnitDto;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UnitDto> addLength(@PathVariable String values, @PathVariable String requiredunit) throws UnitLengthException {
        List<QuantityMeasurementService> listOfUnits=new ArrayList<QuantityMeasurementService>();
        String[] splitvalues=values.split(",");
        UnitDto unitDto=new UnitDto();
        for(String value:splitvalues){
            String[] splitargs=value.split(":");
            listOfUnits.add(new QuantityMeasurementService(Units.valueOf(splitargs[0].toUpperCase()),
                    Double.parseDouble(splitargs[1])+0.00));
        }
        QuantityMeasurementService value=quantityMeasurementService.add(listOfUnits,
                Units.valueOf(requiredunit.toUpperCase()));
        unitDto.setValue(String.valueOf(value.getQuantity()));
        unitDto.setMessage("Operation Sucessful");
        unit=new Unit(String.valueOf(value.getUnits())+" "+String.valueOf(value.getQuantity()/
                (Double) Units.valueOf(requiredunit.toUpperCase()).getValue()[1]));
        System.out.println(unit+"Printing from contorller");
        return new ResponseEntity<UnitDto>(unitDto,HttpStatus.OK);
    }

    @PostMapping("/sum")
    public ResponseEntity<UnitDto> addLengthFromPostMethod(@RequestBody Unit unit) throws UnitLengthException {
        String  requiredunit=unit.getValue();
        UnitDto unitDto=new UnitDto();
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
        unitDto.setValue(String.valueOf(value.getQuantity()));
        unitDto.setMessage("Operation Sucessfull");
      }catch (IllegalArgumentException|UnitLengthException e){
        throw new QuantityMeasurementResponseException("Invalid Conversion to "+requiredunit);
      }
        return new ResponseEntity<UnitDto>(unitDto,HttpStatus.OK);
    }

    @GetMapping("/convert/{unitIn}/{value}/{unitOut}")
    public String convertUnit(@PathVariable Units unitIn,@PathVariable Units unitOut ,@PathVariable double value )
            throws UnitLengthException {
        Double result=null;
       try {
             result=quantityMeasurementService.convert(unitIn
                   ,value+0.0,
                     unitOut);
       }catch(UnitLengthException e){
           throw new QuantityMeasurementResponseException("Invalid Unit conversion to "+String.valueOf(unitOut));
       }
        return String.valueOf(result);
    }

    @GetMapping(/baseunits)
    public String returnBaseUnit(){

    }


}

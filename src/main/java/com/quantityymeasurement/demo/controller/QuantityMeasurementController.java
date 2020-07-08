package com.quantityymeasurement.demo.controller;

import com.quantityymeasurement.demo.enumeration.BaseUnit;
import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.exception.QuantityMeasurementResponseException;
import com.quantityymeasurement.demo.response.BaseUnitsDto;
import com.quantityymeasurement.demo.model.Unit;
import com.quantityymeasurement.demo.response.UnitDto;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quantitymeasurement")
@Api(value = "Quantity Measurement API")
public class QuantityMeasurementController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuantityMeasurementService quantityMeasurementService;

    Unit unit;

    @ApiOperation(value = "Addition Operation Type1")
    @GetMapping("/addition/{values}/unit/{requiredunit}")
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
        unitDto.setStatus(HttpStatus.OK.value());
        unit=new Unit(String.valueOf(value.getUnits())+" "+String.valueOf(value.getQuantity()/
                (Double) Units.valueOf(requiredunit.toUpperCase()).getValue()[1]));
        System.out.println(unit+"Printing from contorller");
        return new ResponseEntity<UnitDto>(unitDto,HttpStatus.OK);
    }

    @ApiOperation(value = "Addition Operation Input:JSON")
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
        unitDto.setStatus(HttpStatus.OK.value());
      }catch (IllegalArgumentException|UnitLengthException e){
        throw new QuantityMeasurementResponseException("Invalid Conversion to "+requiredunit);
      }
        return new ResponseEntity<UnitDto>(unitDto,HttpStatus.OK);
    }

    @ApiOperation(value = "Converson Operation")
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

    @ApiOperation(value = "Display SubUnits of Selected Base Unit")
    @GetMapping("/baseunits/{baseUnits}")
    public ResponseEntity<BaseUnitsDto> returnSubUnit(BaseUnit baseUnits ){
        List<Units> listOfUnits=new ArrayList<Units>(EnumSet.allOf(Units.class));
        List listOfSubUnits= listOfUnits.stream().filter(units->units.getValue()[0]==baseUnits)
                .collect(Collectors.toCollection(ArrayList::new));
        BaseUnitsDto baseUnitsDto=new BaseUnitsDto("Printing all subunits of "+String.valueOf(baseUnits)
                ,listOfSubUnits,200);
        return new ResponseEntity<BaseUnitsDto>(baseUnitsDto,HttpStatus.OK);
    }

    @ApiOperation(value = "Display all SubUnits")
    @GetMapping("/subunits")
    public ResponseEntity<BaseUnitsDto> returnAllSubUnits(){
        List<Units> listOfUnits=new ArrayList<Units>(EnumSet.allOf(Units.class));

        BaseUnitsDto baseUnitsDto=new BaseUnitsDto("Printing all subunits",listOfUnits,200);
        return new ResponseEntity<BaseUnitsDto>(baseUnitsDto,HttpStatus.OK);
    }

    @ApiOperation(value = "Display all BaseUnits")
    @GetMapping("/baseunits")
    public ResponseEntity<BaseUnitsDto> returnBaseUnit(BaseUnit baseUnit){
        List<BaseUnit> listOfUnits=new ArrayList<BaseUnit>(EnumSet.allOf(BaseUnit.class));
        BaseUnitsDto baseUnitsDto=new BaseUnitsDto("Printing all baseUnits",listOfUnits,200);
        return new ResponseEntity<BaseUnitsDto>(baseUnitsDto,HttpStatus.OK);
    }

}

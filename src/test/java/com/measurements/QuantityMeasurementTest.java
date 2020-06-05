package com.measurements;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementTest {

    @Test
    public void givenSamelengthsOfInch_whenCompared_shouldReturnTrue() {
        try {
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH, 1.0);
            QuantityMeasurement inch1 = new QuantityMeasurement(LengthUnits.INCH, 1.0);
            Assert.assertEquals(inch,inch1);
        }catch(UnitLengthException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoZeroValues_whenCreated_shouldReturnSameReference()  {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,0.0);
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,0.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = null;
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void givenTwoIdenticalValues_when1InchNotEqualTo1Feet_shouldReturnFalse()  {
        try {
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT, 1.0);
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH, 1.0);
            Assert.assertFalse(inch.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenTwoIdenticalValues_when1feetNotEqualTo1Inch_shouldReturnFalse()  {
        try {
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT, 1.0);
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH, 1.0);
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,12.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_when12InchEqualTo1Foot_shouldReturnSameReference() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,12.0);
            Assert.assertEquals(inch,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,3.0);
            QuantityMeasurement yard = new QuantityMeasurement(LengthUnits.YARD,1.0);
            Assert.assertEquals(yard,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(LengthUnits.FOOT,1.0);
            QuantityMeasurement yard = new QuantityMeasurement(LengthUnits.YARD,1.0);
            Assert.assertFalse(yard.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,1.0);
            QuantityMeasurement yard = new QuantityMeasurement(LengthUnits.YARD,1.0);
            Assert.assertFalse(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given36InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,36.0);
            QuantityMeasurement yard = new QuantityMeasurement(LengthUnits.YARD,1.0);
            Assert.assertTrue(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1YardAnd3Feet_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(LengthUnits.INCH,36.0);
            QuantityMeasurement yard = new QuantityMeasurement(LengthUnits.YARD,1.0);
            Assert.assertTrue(inch.equals(yard));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInFoot() {
        try{
           QuantityMeasurement yardtoFoot=new QuantityMeasurement();
           double foot=yardtoFoot.convert(LengthUnits.YARD,1.0, LengthUnits.FOOT);
           Assert.assertEquals(3.0,foot,.01);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInInch() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(LengthUnits.YARD,1.0, LengthUnits.INCH);
            Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInFoot() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(LengthUnits.INCH,1.0, LengthUnits.FOOT);
            Assert.assertEquals(0.083,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInYard() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(LengthUnits.INCH,1.0, LengthUnits.YARD);
            Assert.assertEquals(0.027,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2Inch_whenAdded_shouldReturnInInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
        e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd2InchAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,14.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1InchAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,24.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInchAndCentiMetersAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.CENTIMETER,2.5));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,2.98);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1InchAnd1Inch_whenAdded_shouldReturnFalseOutPut() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,1.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,3.0);
            Assert.assertNotEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3InchAnd1Inch_whenAdded_shouldReturnInInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void given3FeetAnd1Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,37.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd1Inch_whenAdded_shouldReturnFeet() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.FOOT);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.FOOT,3.08);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd3Inch_whenAdded_shouldReturnFeet() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.YARD,1.08);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3Foot_whenAdded_shouldReturnYard() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.YARD,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3Foot_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,144.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3FootAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(LengthUnits.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths,LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(LengthUnits.INCH,147.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }



    //    @Test
//    public void givenCelcius_whenCoverted_shouldReturnItInKelvin() {
//        try{
//            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
//            double foot=yardtoFoot.convert(TemperatureUnits.CELCIUS,1.0, TemperatureUnits.KELVIN);
//            Assert.assertEquals(274.15,foot,.1);
//        } catch (UnitLengthException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void givenCelcius_whenCompared_shouldReturnItInKelvin() {
//        try{
//            QuantityMeasurement celcuis=new QuantityMeasurement(TemperatureUnits.CELCIUS,30.0);
//            QuantityMeasurement kelvin=new QuantityMeasurement(TemperatureUnits.KELVIN,303.15);
//            Assert.assertEquals(celcuis,kelvin);
//        } catch (UnitLengthException e) {
//            e.printStackTrace();
//        }
//    }





}

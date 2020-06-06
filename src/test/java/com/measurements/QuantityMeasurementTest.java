package com.measurements;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementTest {

    @Test
    public void givenSamelengthsOfInch_whenCompared_shouldReturnTrue() {
        try {
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH, 1.0);
            QuantityMeasurement inch1 = new QuantityMeasurement(Units.LengthUnits.INCH, 1.0);
            Assert.assertEquals(inch,inch1);
        }catch(UnitLengthException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoZeroValues_whenCreated_shouldReturnSameReference()  {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,0.0);
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,0.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = null;
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void givenTwoIdenticalValues_when1InchNotEqualTo1Feet_shouldReturnFalse()  {
        try {
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT, 1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH, 1.0);
            Assert.assertFalse(inch.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenTwoIdenticalValues_when1feetNotEqualTo1Inch_shouldReturnFalse()  {
        try {
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT, 1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH, 1.0);
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,12.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_when12InchEqualTo1Foot_shouldReturnSameReference() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,1.0);
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,12.0);
            Assert.assertEquals(inch,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,3.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.LengthUnits.YARD,1.0);
            Assert.assertEquals(yard,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement foot = new QuantityMeasurement(Units.LengthUnits.FOOT,1.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.LengthUnits.YARD,1.0);
            Assert.assertFalse(yard.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,1.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.LengthUnits.YARD,1.0);
            Assert.assertFalse(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given36InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,36.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.LengthUnits.YARD,1.0);
            Assert.assertTrue(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1YardAnd3Feet_whenCompared_shouldReturnTrue() {
        try{
            QuantityMeasurement inch = new QuantityMeasurement(Units.LengthUnits.INCH,36.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.LengthUnits.YARD,1.0);
            Assert.assertTrue(inch.equals(yard));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInFoot() {
        try{
           QuantityMeasurement yardtoFoot=new QuantityMeasurement();
           double foot=yardtoFoot.convert(Units.LengthUnits.YARD,1.0, Units.LengthUnits.FOOT);
           Assert.assertEquals(3.0,foot,.01);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInInch() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.LengthUnits.YARD,1.0, Units.LengthUnits.INCH);
            Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given2Inch_whenConvertedtoCentimeter_shouldReturn5Centimeter() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.LengthUnits.INCH,2.0, Units.LengthUnits.CENTIMETER);
            Assert.assertEquals(5,foot,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInFoot() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.LengthUnits.INCH,1.0, Units.LengthUnits.FOOT);
            Assert.assertEquals(0.083,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInYard() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.LengthUnits.INCH,1.0, Units.LengthUnits.YARD);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,4.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,14.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,24.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.CENTIMETER,2.5));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,2.98);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,3.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,4.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,37.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.FOOT);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.FOOT,3.08);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.YARD,1.08);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.YARD,4.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,144.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LengthUnits.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.LengthUnits.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LengthUnits.INCH,147.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

//VOLUME TESTING STARTS FROM HERE
    @Test
    public void given1Gallon_whenConverted_shouldReturnInlitrePositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.VolumeUnits.GALLON,1.0, Units.VolumeUnits.LITER);
            Assert.assertEquals(3.78,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Gallon_whenConverted_shouldReturnInlitreNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.VolumeUnits.GALLON,1.0, Units.VolumeUnits.LITER);
            Assert.assertNotEquals(3.2,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitre() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.VolumeUnits.LITER,1.0, Units.VolumeUnits.MILLILITER);
            Assert.assertEquals(1000,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitreNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.VolumeUnits.LITER,1.0, Units.VolumeUnits.MILLILITER);
            Assert.assertNotEquals(10000,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenGallonAndLiters_whenAdded_shouldReturnInLiters() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.GALLON,1.0));
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.LITER,3.78));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.VolumeUnits.LITER);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.VolumeUnits.LITER,7.57);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLiterAndMilliliter_whenAdded_shouldReturnInLiters() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.LITER,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.VolumeUnits.LITER);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.VolumeUnits.LITER,2.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLiterAndMilliliter_whenAdded_shouldReturnInGallon() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.VolumeUnits.LITER,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.VolumeUnits.GALLON);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.VolumeUnits.GALLON,0.53);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.WeightUnits.KILOGRAM,1.0, Units.WeightUnits.GRAMS);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.WeightUnits.KILOGRAM,1.0, Units.WeightUnits.GRAMS);
            Assert.assertNotEquals(10000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.WeightUnits.TONNE,1.0, Units.WeightUnits.KILOGRAM);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.WeightUnits.TONNE,1.0, Units.WeightUnits.KILOGRAM);
            Assert.assertNotEquals(10000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTonnwAndGram_whenAdded_shouldReturnInKilogram() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.WeightUnits.GRAMS,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.WeightUnits.TONNE,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.WeightUnits.KILOGRAM);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.WeightUnits.KILOGRAM,1001.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTonnwAndGram_whenAdded_shouldReturnInTonne() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.WeightUnits.KILOGRAM,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.WeightUnits.TONNE,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.WeightUnits.TONNE);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.WeightUnits.TONNE,2.00);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFarenHiet_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double celcuis=quantityMeasurement.convert(Units.TemperatureUnits.FAHRENHIET,212.0, Units.TemperatureUnits.CELCIUS);
            Assert.assertEquals(100,celcuis,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenCelcuisAndKelvin_whenAdded_shouldReturnInFahrenheit() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurement(Units.TemperatureUnits.CELCIUS,30.0));
            listOfLengths.add( new QuantityMeasurement(Units.TemperatureUnits.KELVIN,373.15));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.TemperatureUnits.FAHRENHIET);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.TemperatureUnits.FAHRENHIET,266.0);
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

package com.measurements;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementTest {

    @Test
    public void givenSamelengthsOfInch_whenCompared_shouldReturnTrue() {
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH, 1.0);
        QuantityMeasurement inch1 = new QuantityMeasurement(Units.INCH, 1.0);
        Assert.assertEquals(inch,inch1);
    }

    @Test
    public void givenTwoZeroValues_whenCreated_shouldReturnSameReference()  {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,0.0);
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH,0.0);
        Assert.assertEquals(foot,inch);
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,1.0);
        QuantityMeasurement inch = null;
        Assert.assertFalse(foot.equals(inch));
    }

    @Test
    public void givenTwoIdenticalValues_when1InchNotEqualTo1Feet_shouldReturnFalse()  {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT, 1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH, 1.0);
        Assert.assertNotEquals(inch,foot);
    }
    @Test
    public void givenTwoIdenticalValues_when1feetNotEqualTo1Inch_shouldReturnFalse()  {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT, 1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH, 1.0);
        Assert.assertFalse(foot.equals(inch));
    }


    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH,12.0);
        Assert.assertEquals(foot,inch);
    }

    @Test
    public void givenTwoValues_when12InchEqualTo1Foot_shouldReturnSameReference() {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH,12.0);
        Assert.assertEquals(inch,foot);
    }

    @Test
    public void given3FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,3.0);
        QuantityMeasurement yard = new QuantityMeasurement(Units.YARD,1.0);
        Assert.assertEquals(yard,foot);
    }

    @Test
    public void given1FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        QuantityMeasurement foot = new QuantityMeasurement(Units.FOOT,1.0);
        QuantityMeasurement yard = new QuantityMeasurement(Units.YARD,1.0);
        Assert.assertFalse(yard.equals(foot));
    }

    @Test
    public void given1InchAnd1Yard_whenCompared_shouldReturnTrue() {
            QuantityMeasurement inch = new QuantityMeasurement(Units.MILLILITER,1.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.YARD,1.0);
            Assert.assertFalse(yard.equals(inch));

    }

    @Test
    public void given36InchAnd1Yard_whenCompared_shouldReturnTrue() {
            QuantityMeasurement inch = new QuantityMeasurement(Units.INCH,36.0);
            QuantityMeasurement yard = new QuantityMeasurement(Units.YARD,1.0);
            Assert.assertTrue(yard.equals(inch));

    }

    @Test
    public void given1YardAnd3Feet_whenCompared_shouldReturnTrue() {
        QuantityMeasurement inch = new QuantityMeasurement(Units.INCH,36.0);
        QuantityMeasurement yard = new QuantityMeasurement(Units.YARD,1.0);
        Assert.assertTrue(inch.equals(yard));
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInFoot() {
        try{
           QuantityMeasurement yardtoFoot=new QuantityMeasurement();
           double foot=yardtoFoot.convert(Units.YARD,1.0, Units.FOOT);
           Assert.assertEquals(3.0,foot,.01);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInInch() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.YARD,1.0, Units.INCH);
            Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void given1Yard_whenCoverted_shouldthrowException() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.YARD,1.0, Units.LITER);
          //  Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
            Assert.assertEquals(UnitLengthException.ExceptionType.INVALID_CONVERSION,e.type);
        }
    }

    @Test
    public void given2Inch_whenConvertedtoCentimeter_shouldReturn5Centimeter() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.INCH,2.0, Units.CENTIMETER);
            Assert.assertEquals(5,foot,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInFoot() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.INCH,1.0, Units.FOOT);
            Assert.assertEquals(0.083,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInYard() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.INCH,1.0, Units.YARD);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
        e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2Litre_whenAdded_shouldThroughException() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.LITER,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,4.0);
        }catch (UnitLengthException e) {
            Assert.assertEquals(UnitLengthException.ExceptionType.INVALID_CONVERSION,e.type);

            e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2LitreForWrongUnite_whenAdded_shouldThroughException() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.MILLILITER);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,4.0);
        }catch (UnitLengthException e) {
            Assert.assertEquals(UnitLengthException.ExceptionType.INVALID_CONVERSION,e.type);

            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd2InchAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            List<QuantityMeasurement> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,14.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,24.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,2.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.CENTIMETER,2.5));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,2.98);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,1.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,3.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,4.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,37.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.FOOT);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.FOOT,3.08);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.YARD,1.08);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.YARD);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.YARD,4.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,144.0);
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
            lisyOfLengths.add( new QuantityMeasurement(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurement(Units.INCH,3.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(lisyOfLengths, Units.INCH);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.INCH,147.0);
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
            double litre=quantityMeasurement.convert(Units.GALLON,1.0, Units.LITER);
            Assert.assertEquals(3.78,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Gallon_whenConverted_shouldReturnInlitreNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.GALLON,1.0, Units.LITER);
            Assert.assertNotEquals(3.2,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitre() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.LITER,1.0, Units.MILLILITER);
            Assert.assertEquals(1000,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitreNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double litre=quantityMeasurement.convert(Units.LITER,1.0, Units.MILLILITER);
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
            listOfLengths.add( new QuantityMeasurement(Units.GALLON,1.0));
            listOfLengths.add( new QuantityMeasurement(Units.LITER,3.78));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.LITER);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LITER,7.56);
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
            listOfLengths.add( new QuantityMeasurement(Units.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.LITER,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.LITER);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.LITER,2.0);
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
            listOfLengths.add( new QuantityMeasurement(Units.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.LITER,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.GALLON);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.GALLON,0.53);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.KILOGRAM,1.0, Units.GRAMS);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.KILOGRAM,1.0, Units.GRAMS);
            Assert.assertNotEquals(10000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.TONNE,1.0, Units.KILOGRAM);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramNegativeTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double grams=quantityMeasurement.convert(Units.TONNE,1.0, Units.KILOGRAM);
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
            listOfLengths.add( new QuantityMeasurement(Units.GRAMS,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.TONNE,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.KILOGRAM);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.KILOGRAM,1001.0);
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
            listOfLengths.add( new QuantityMeasurement(Units.KILOGRAM,1000.0));
            listOfLengths.add( new QuantityMeasurement(Units.TONNE,1.0));
            QuantityMeasurement actualObject=quantityMeasurement.add(listOfLengths, Units.TONNE);
            QuantityMeasurement expectedObject=new QuantityMeasurement(Units.TONNE,2.00);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFarenHiet_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurement quantityMeasurement=new QuantityMeasurement();
            double celcuis=quantityMeasurement.convert(Units.FAHRENHIET,212.0, Units.CELCIUS);
            Assert.assertEquals(100,celcuis,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }





        @Test
    public void givenCelcius_whenCoverted_shouldReturnItInKelvin() {
        try{
            QuantityMeasurement yardtoFoot=new QuantityMeasurement();
            double foot=yardtoFoot.convert(Units.CELCIUS,1.0, Units.KELVIN);
            Assert.assertEquals(274.15,foot,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCelcius_whenCompared_shouldReturnEqual() {
        QuantityMeasurement celcuis=new QuantityMeasurement(Units.CELCIUS,30.0);
        QuantityMeasurement kelvin=new QuantityMeasurement(Units.KELVIN,303.15);
        Assert.assertEquals(celcuis,kelvin);
    }

//    @Test
//    public void givenCelcius_whenCompared_shouldReturnItInKelvin() {
//        QuantityMeasurement celcuis=new QuantityMeasurement(Units.CELCIUS,30.0);
//        QuantityMeasurement fahrenhiet=new QuantityMeasurement(Units.FAHRENHIET,86.0);
//        Assert.assertEquals(celcuis,fahrenhiet);
//    }




}

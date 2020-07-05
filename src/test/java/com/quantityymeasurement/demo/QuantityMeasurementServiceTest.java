package com.quantityymeasurement.demo;

import com.quantityymeasurement.demo.enumeration.Units;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import com.quantityymeasurement.demo.exception.UnitLengthException;
import com.quantityymeasurement.demo.service.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementServiceTest {

    @Test
    public void givenSamelengthsOfInch_whenCompared_shouldReturnTrue() {
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH, 1.0);
        QuantityMeasurementService inch1 = new QuantityMeasurementService(Units.INCH, 1.0);
        Assert.assertEquals(inch,inch1);
    }

    @Test
    public void givenTwoZeroValues_whenCreated_shouldReturnSameReference()  {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,0.0);
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH,0.0);
        Assert.assertEquals(foot,inch);
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,1.0);
        QuantityMeasurementService inch = null;
        Assert.assertFalse(foot.equals(inch));
    }

    @Test
    public void givenTwoIdenticalValues_when1InchNotEqualTo1Feet_shouldReturnFalse()  {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT, 1.0);
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH, 1.0);
        Assert.assertNotEquals(inch,foot);
    }
    @Test
    public void givenTwoIdenticalValues_when1feetNotEqualTo1Inch_shouldReturnFalse()  {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT, 1.0);
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH, 1.0);
        Assert.assertFalse(foot.equals(inch));
    }


    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,1.0);
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH,12.0);
        Assert.assertEquals(foot,inch);
    }

    @Test
    public void givenTwoValues_when12InchEqualTo1Foot_shouldReturnSameReference() {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,1.0);
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH,12.0);
        Assert.assertEquals(inch,foot);
    }

    @Test
    public void given3FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,3.0);
        QuantityMeasurementService yard = new QuantityMeasurementService(Units.YARD,1.0);
        Assert.assertEquals(yard,foot);
    }

    @Test
    public void given1FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        QuantityMeasurementService foot = new QuantityMeasurementService(Units.FOOT,1.0);
        QuantityMeasurementService yard = new QuantityMeasurementService(Units.YARD,1.0);
        Assert.assertFalse(yard.equals(foot));
    }

    @Test
    public void given1InchAnd1Yard_whenCompared_shouldReturnTrue() {
            QuantityMeasurementService inch = new QuantityMeasurementService(Units.MILLILITER,1.0);
            QuantityMeasurementService yard = new QuantityMeasurementService(Units.YARD,1.0);
            Assert.assertFalse(yard.equals(inch));

    }

    @Test
    public void given36InchAnd1Yard_whenCompared_shouldReturnTrue() {
            QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH,36.0);
            QuantityMeasurementService yard = new QuantityMeasurementService(Units.YARD,1.0);
            Assert.assertTrue(yard.equals(inch));

    }

    @Test
    public void given1YardAnd3Feet_whenCompared_shouldReturnTrue() {
        QuantityMeasurementService inch = new QuantityMeasurementService(Units.INCH,36.0);
        QuantityMeasurementService yard = new QuantityMeasurementService(Units.YARD,1.0);
        Assert.assertTrue(inch.equals(yard));
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInFoot() {
        try{
           QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
           double foot=yardtoFoot.convert(Units.YARD,1.0, Units.FOOT);
           Assert.assertEquals(3.0,foot,.01);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCoverted_shouldReturnItInInch() {
        try{
            QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
            double foot=yardtoFoot.convert(Units.YARD,1.0, Units.INCH);
            Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void given1Yard_whenCoverted_shouldthrowException() {
        try{
            QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
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
            QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
            double foot=yardtoFoot.convert(Units.INCH,2.0, Units.CENTIMETER);
            Assert.assertEquals(5,foot,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInFoot() {
        try{
            QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
            double foot=yardtoFoot.convert(Units.INCH,1.0, Units.FOOT);
            Assert.assertEquals(0.083,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCoverted_shouldReturnItInYard() {
        try{
            QuantityMeasurementService yardtoFoot=new QuantityMeasurementService();
            double foot=yardtoFoot.convert(Units.INCH,1.0, Units.YARD);
            Assert.assertEquals(0.027,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2Inch_whenAdded_shouldReturnInInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
        e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2Litre_whenAdded_shouldThroughException() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            listOfLengths.add( new QuantityMeasurementService(Units.LITER,2.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,4.0);
        }catch (UnitLengthException e) {
            Assert.assertEquals(UnitLengthException.ExceptionType.INVALID_CONVERSION,e.type);

            e.printStackTrace();
        }
    }

    @Test
    public void given2InchAnd2LitreForWrongUnite_whenAdded_shouldThroughException() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            listOfLengths.add( new QuantityMeasurementService(Units.FOOT,2.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.MILLILITER);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,4.0);
        }catch (UnitLengthException e) {
            Assert.assertEquals(UnitLengthException.ExceptionType.INVALID_CONVERSION,e.type);

            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd2InchAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.FOOT,1.0));
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,14.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1InchAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.FOOT,1.0));
            listOfLengths.add( new QuantityMeasurementService(Units.FOOT,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,24.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInchAndCentiMetersAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.INCH,2.0));
            listOfLengths.add( new QuantityMeasurementService(Units.CENTIMETER,2.5));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,2.98);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1InchAnd1Inch_whenAdded_shouldReturnFalseOutPut() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,1.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,3.0);
            Assert.assertNotEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3InchAnd1Inch_whenAdded_shouldReturnInInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void given3FeetAnd1Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,37.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd1Inch_whenAdded_shouldReturnFeet() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.FOOT);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.FOOT,3.08);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd3Inch_whenAdded_shouldReturnFeet() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,3.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.YARD);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.YARD,1.08);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3Foot_whenAdded_shouldReturnYard() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.YARD);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.YARD,4.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3Foot_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,144.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3YardAnd3FootAnd3Inch_whenAdded_shouldReturnInch() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> lisyOfLengths=new ArrayList();
            lisyOfLengths.add( new QuantityMeasurementService(Units.YARD,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.FOOT,3.0));
            lisyOfLengths.add( new QuantityMeasurementService(Units.INCH,3.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(lisyOfLengths, Units.INCH);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.INCH,147.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

//VOLUME TESTING STARTS FROM HERE
    @Test
    public void given1Gallon_whenConverted_shouldReturnInlitrePositiveTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double litre= quantityMeasurementService.convert(Units.GALLON,1.0, Units.LITER);
            Assert.assertEquals(3.78,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Gallon_whenConverted_shouldReturnInlitreNegativeTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double litre= quantityMeasurementService.convert(Units.GALLON,1.0, Units.LITER);
            Assert.assertNotEquals(3.2,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitre() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double litre= quantityMeasurementService.convert(Units.LITER,1.0, Units.MILLILITER);
            Assert.assertEquals(1000,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Litre_whenConverted_shouldReturnInMilliLitreNegativeTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double litre= quantityMeasurementService.convert(Units.LITER,1.0, Units.MILLILITER);
            Assert.assertNotEquals(10000,litre,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenGallonAndLiters_whenAdded_shouldReturnInLiters() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.GALLON,1.0));
            listOfLengths.add( new QuantityMeasurementService(Units.LITER,3.78));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.LITER);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.LITER,7.56);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLiterAndMilliliter_whenAdded_shouldReturnInLiters() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurementService(Units.LITER,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.LITER);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.LITER,2.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenLiterAndMilliliter_whenAdded_shouldReturnInGallon() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.MILLILITER,1000.0));
            listOfLengths.add( new QuantityMeasurementService(Units.LITER,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.GALLON);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.GALLON,0.53);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramPositiveTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double grams= quantityMeasurementService.convert(Units.KILOGRAM,1.0, Units.GRAMS);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void given1Kilogram_whenConverted_shouldReturnInGramNegativeTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double grams= quantityMeasurementService.convert(Units.KILOGRAM,1.0, Units.GRAMS);
            Assert.assertNotEquals(10000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double grams= quantityMeasurementService.convert(Units.TONNE,1.0, Units.KILOGRAM);
            Assert.assertEquals(1000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Tonne_whenConverted_shouldReturnInKilogramNegativeTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double grams= quantityMeasurementService.convert(Units.TONNE,1.0, Units.KILOGRAM);
            Assert.assertNotEquals(10000,grams,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTonnwAndGram_whenAdded_shouldReturnInKilogram() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.GRAMS,1000.0));
            listOfLengths.add( new QuantityMeasurementService(Units.TONNE,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.KILOGRAM);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.KILOGRAM,1001.0);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTonnwAndGram_whenAdded_shouldReturnInTonne() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            List<QuantityMeasurementService> listOfLengths=new ArrayList();
            listOfLengths.add( new QuantityMeasurementService(Units.KILOGRAM,1000.0));
            listOfLengths.add( new QuantityMeasurementService(Units.TONNE,1.0));
            QuantityMeasurementService actualObject= quantityMeasurementService.add(listOfLengths, Units.TONNE);
            QuantityMeasurementService expectedObject=new QuantityMeasurementService(Units.TONNE,2.00);
            Assert.assertEquals(actualObject,expectedObject);
        }catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFarenHiet_whenConverted_shouldReturnInKilogramPositiveTesting() {
        try{
            QuantityMeasurementService quantityMeasurementService =new QuantityMeasurementService();
            double celcuis= quantityMeasurementService.convert(Units.FAHRENHIET,212.0, Units.CELCIUS);
            Assert.assertEquals(100,celcuis,.1);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCelcius_whenCompared_shouldReturnEqual() {
        QuantityMeasurementService celcuis=new QuantityMeasurementService(Units.CELCIUS,30.0);
        QuantityMeasurementService kelvin=new QuantityMeasurementService(Units.KELVIN,303.15);
        Assert.assertEquals(celcuis,kelvin);
    }

//    @Test
//    public void givenCelcius_whenCompared_shouldReturnItInKelvin() {
//        QuantityMeasurement celcuis=new QuantityMeasurement(Units.CELCIUS,30.0);
//        QuantityMeasurement fahrenhiet=new QuantityMeasurement(Units.FAHRENHIET,86.0);
//        Assert.assertEquals(celcuis,fahrenhiet);
//    }




}

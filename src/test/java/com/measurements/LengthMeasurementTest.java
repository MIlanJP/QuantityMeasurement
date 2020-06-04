package com.measurements;

import org.junit.Assert;
import org.junit.Test;

public class LengthMeasurementTest {

    @Test
    public void givenSamelengthsOfInch_whenCompared_shouldReturnTrue() {
        try {
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH, 1.0);
            LengthMeasurement inch1 = new LengthMeasurement(Unit.INCH, 1.0);
            Assert.assertEquals(inch,inch1);
        }catch(UnitLengthException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoZeroValues_whenCreated_shouldReturnSameReference()  {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,0.0);
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,0.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,1.0);
            LengthMeasurement inch = null;
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void givenTwoIdenticalValues_when1InchNotEqualTo1Feet_shouldReturnFalse()  {
        try {
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT, 1.0);
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH, 1.0);
            Assert.assertFalse(inch.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenTwoIdenticalValues_when1feetNotEqualTo1Inch_shouldReturnFalse()  {
        try {
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT, 1.0);
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH, 1.0);
            Assert.assertFalse(foot.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,1.0);
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,12.0);
            Assert.assertEquals(foot,inch);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoValues_when12InchEqualTo1Foot_shouldReturnSameReference() {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,1.0);
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,12.0);
            Assert.assertEquals(inch,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given3FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,3.0);
            LengthMeasurement yard = new LengthMeasurement(Unit.YARD,1.0);
            Assert.assertEquals(yard,foot);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            LengthMeasurement foot = new LengthMeasurement(Unit.FOOT,1.0);
            LengthMeasurement yard = new LengthMeasurement(Unit.YARD,1.0);
            Assert.assertFalse(yard.equals(foot));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,1.0);
            LengthMeasurement yard = new LengthMeasurement(Unit.YARD,1.0);
            Assert.assertFalse(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given36InchAnd1Yard_whenCompared_shouldReturnTrue() {
        try{
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,36.0);
            LengthMeasurement yard = new LengthMeasurement(Unit.YARD,1.0);
            Assert.assertTrue(yard.equals(inch));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1YardAnd3Feet_whenCompared_shouldReturnTrue() {
        try{
            LengthMeasurement inch = new LengthMeasurement(Unit.INCH,36.0);
            LengthMeasurement yard = new LengthMeasurement(Unit.YARD,1.0);
            Assert.assertTrue(inch.equals(yard));
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCompared_shouldReturnItInFoot() {
        try{
           LengthMeasurement yardtoFoot=new LengthMeasurement();
           double foot=yardtoFoot.returnAs(Unit.YARD,1.0,Unit.FOOT);
           Assert.assertEquals(3.0,foot,.01);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Yard_whenCompared_shouldReturnItInInch() {
        try{
            LengthMeasurement yardtoFoot=new LengthMeasurement();
            double foot=yardtoFoot.returnAs(Unit.YARD,1.0,Unit.INCH);
            Assert.assertEquals(36.0,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCompared_shouldReturnItInFoot() {
        try{
            LengthMeasurement yardtoFoot=new LengthMeasurement();
            double foot=yardtoFoot.returnAs(Unit.INCH,1.0,Unit.FOOT);
            Assert.assertEquals(0.083,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given1Inch_whenCompared_shouldReturnItInYard() {
        try{
            LengthMeasurement yardtoFoot=new LengthMeasurement();
            double foot=yardtoFoot.returnAs(Unit.INCH,1.0,Unit.YARD);
            Assert.assertEquals(0.027,foot,.02);
        } catch (UnitLengthException e) {
            e.printStackTrace();
        }
    }





}

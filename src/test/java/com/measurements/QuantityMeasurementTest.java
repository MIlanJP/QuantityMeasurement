package com.measurements;

import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {
    @Test
    public void givenSamelengthsOfDifferentUnits_whenCompared_shouldReturnTrue() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        Assert.assertTrue( quantityMeasurement.compareLengths(1,12));
    }

    @Test
    public void givenSamelengthsOfDifferentUnits_whenCompared_shouldReturnFalse() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        Assert.assertFalse( quantityMeasurement.compareLengths(1,13));
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnSameReference() {
        QuantityMeasurement foot = new QuantityMeasurement(Unit.FOOT,1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH,12.0);
        Assert.assertEquals(foot,inch);
    }

    @Test
    public void givenTwoValues_whenCreated_shouldReturnNull() {
        QuantityMeasurement foot = new QuantityMeasurement(Unit.FOOT,1.0);
        QuantityMeasurement inch = new QuantityMeasurement(Unit.INCH,12.0);
        Assert.assertFalse(foot.equals(null));
        Assert.assertFalse(inch.equals(null));
    }


}

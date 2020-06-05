package com.measurements;

public enum TemperatureUnits {
    CELCIUS((9/5),32),FAHRENHIET(32,(5/9)),KELVIN(273.15);

    double[] temperatureValues;
    TemperatureUnits(double ... tempvalues) {
        this.temperatureValues = tempvalues;
    }

    public double getFirstValue() {
        return temperatureValues[0];
    }

    public double getSecondValue() {
        return temperatureValues[1];
    }
}
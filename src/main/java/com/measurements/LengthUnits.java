package com.measurements;


public enum LengthUnits {
    INCH(1.0),FOOT(12.0),YARD(36.0),CENTIMETER(.393701);
    private Double value;

    LengthUnits(Double value) {
    this.value = value;
    }

    public Double getValue() {
        return value;
    }

     enum TemperatureUnits {
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



}

package com.measurements;

public enum Units {
    MAINENUM;


    enum LengthUnits{
        INCH(1.0),FOOT(12.0),YARD(36.0),CENTIMETER(.393701);
        private Double value;

        LengthUnits(Double value) {
            this.value = value;
        }

        public Double getLengthValue() {
            return value;
        }
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


    enum VolumeUnits {
        MILLILITER(1.0),GALLON(3785.41),LITER(1000);

        double volumeValue;

        VolumeUnits(double volumeValue) {
            this.volumeValue = volumeValue;
        }

        public Double getVolumeValue() {
            return volumeValue;
        }

    }

    enum WeightUnits{
        GRAMS(1.0),KILOGRAM(1000.0),TONNE(1000000.0);
        private Double value;

        WeightUnits(Double value) {
            this.value = value;
        }

        public Double getWeightValue() {
            return value;
        }
    }

}

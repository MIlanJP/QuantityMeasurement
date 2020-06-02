package com.measurements;

public enum Unit {
    INCH(1.0),FOOT(12.0),YARD(36.0);

    private Double value;
    Unit(Double value) {
    this.value = value;
    }

    public Double getValue() {
        return value;
    }
}

package com.measurements;

public enum Units {
    INCH("LENGTH",1.0),FOOT("LENGTH",12.0),YARD("LENGTH",36.0),
    KILOGRAM("WEIGHT",1.0),GRAM("WEIGHT",.001),TONNE("WEIGHT",1000.0),
    LITER("VOLUME",1000),MILLILITER("VOLUME",1),GALLON("VOLUME",3780),
    CELCIUS("TEMPERATURE",1.0),
    KELVIN("TEMPERATURE",273.15),
    FAHRENHIETIN("TEMPERATURE",1.8,32),
    FAHRENHIETOUT("TEMPERATURE",32,(1.0/1.8));

    private final Object[] values;

    Units( Object ... values) {
        this.values = values;
    }

    public Object[] getValue() {
        return values;
    }



}

package com.quantityymeasurement.demo.enumeration;

public enum Units {
    INCH(BaseUnit.LENGTH,1.0),FOOT(BaseUnit.LENGTH,12.0),YARD(BaseUnit.LENGTH,36.0),CENTIMETER(BaseUnit.LENGTH,.393701),
    KILOGRAM(BaseUnit.WEIGHT,1.0),GRAMS(BaseUnit.WEIGHT,.001),TONNE(BaseUnit.WEIGHT,1000.0),
    LITER(BaseUnit.VOLUME,1000.0),MILLILITER(BaseUnit.VOLUME,1.0),GALLON(BaseUnit.VOLUME,3780.00),
    CELCIUS("TEMPERATURE",1.0),
    KELVIN("TEMPERATURE",273.15),
    FAHRENHIET("TEMPERATURE",1.8,32.0)
   //. FAHRENHIETOUT("TEMPERATURE",32,(1.0/1.8))
    ;

    private final Object[] values;

    Units(Object ... values) {
        this.values = values;
    }

    public Object[] getValue() {
        return values;
    }

    enum BaseUnit{
        LENGTH,WEIGHT,VOLUME
    }

}

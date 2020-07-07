package com.quantityymeasurement.demo.model;

import java.util.Objects;

public class UnitDto {
    private String message;
    private String value;

    public UnitDto(String message, String value) {
        this.message = message;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitDto unitDto = (UnitDto) o;
        return Objects.equals(message, unitDto.message) &&
                Objects.equals(value, unitDto.value);
    }

    public UnitDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

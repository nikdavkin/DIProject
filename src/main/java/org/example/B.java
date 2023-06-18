package org.example;

import org.example.annotations.NotSpringAutowired;

public class B {
    @NotSpringAutowired
    private A fieldA;

    public A getFieldA() {
        return fieldA;
    }

    public void setFieldA(A fieldA) {
        this.fieldA = fieldA;
    }

    @Override
    public String toString() {
        return "B{" +
                "fieldA=" + fieldA +
                '}';
    }
}

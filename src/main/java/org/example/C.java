package org.example;

import org.example.annotations.NotSpringAutowired;

public class C {
    @NotSpringAutowired
    private A fieldA;
    @NotSpringAutowired
    private B fieldB;

    public A getFieldA() {
        return fieldA;
    }

    public void setFieldA(A fieldA) {
        this.fieldA = fieldA;
    }

    public B getFieldB() {
        return fieldB;
    }

    public void setFieldB(B fieldB) {
        this.fieldB = fieldB;
    }
    @Override
    public String toString() {
        return "C{" +
                "fieldA=" + fieldA +
                ", fieldB=" + fieldB +
                '}';
    }
}

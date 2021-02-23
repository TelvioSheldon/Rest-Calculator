package com.calculator.calculator.model;


import java.math.BigDecimal;
import java.math.MathContext;

public class Operation {
    private float firstValue;
    private float secondValue;
    private BigDecimal result;
    private String operationType;

    public Operation(String operationType, float firstValue, float secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operationType = operationType;
        this.calculate();
    }

    public Operation() {
    }

    public float getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(float firstValue) {
        this.firstValue = firstValue;
    }

    public float getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(float secondValue) {
        this.secondValue = secondValue;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    private ExpectedResult calculate(){
        BigDecimal v1,v2;
        v1= new BigDecimal(this.firstValue);
        v2= new BigDecimal(this.secondValue);

        switch (this.operationType) {
            case "sum": this.result = v1.add(v2);
            break;
            case "sub" : this.result = v1.subtract(v2);
            break;
            case "pro" : this.result = v1.multiply(v2);
            break;
            case "div" : this.result = v1.divide(v2,MathContext.DECIMAL128);
            break;
            default : this.result= new BigDecimal(0);
        }

        return new ExpectedResult(this.result);
    }


    @Override
    public String toString() {
        return "Operation{" +
                "operationType="  + operationType +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", result=" + result +
                "}";
    }
}

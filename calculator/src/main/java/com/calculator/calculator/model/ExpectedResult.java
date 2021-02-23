package com.calculator.calculator.model;

import java.math.BigDecimal;

public class ExpectedResult implements Result{
    private BigDecimal result;

    public ExpectedResult(BigDecimal result) {
        this.result = result;

    }

    public ExpectedResult() {

    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ExpectedResult{" +
                "result=" + result +
                '}';
    }
}

package com.calculator.calculator.model;


public class UnexpectedResult implements Result{
    private String result;

    public UnexpectedResult( String result){
        this.result=result;
    }

    public String getResult(){
        return this.result;
    }

    public void setResult(String result){
        this.result=result;
    }



}

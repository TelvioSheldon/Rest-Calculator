package com.calculator.calculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private int status;
    private String identifier;
    private Date date;
    private String result;

    public Response(@JsonProperty("status")int status, @JsonProperty("identifier") String identifier, @JsonProperty("result") String result){
        this.status= status;

        this.identifier = identifier;
        this.result=result;
        this.date = new Date(System.currentTimeMillis());
    }


    public String customReponse(){
        return "Response => date= "+this.date.toString()+" headers[status:\""+this.status+"\", identficador= \""+this.identifier+"\"];"+
                "payload="+this.result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", identifier='" + identifier + '\'' +
                ", date=" + date +
                ", result=" + result +
                '}';
    }
}

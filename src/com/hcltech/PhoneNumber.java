package com.hcltech;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String countryCode;
    private String number;
    private String label;

    public PhoneNumber(){}

    public PhoneNumber(String countryCode, String number){
        this.countryCode = countryCode;
        this.number = number;
    }

    public PhoneNumber(String countryCode, String number, String label){
        this.countryCode = countryCode;
        this.number = number;
        this.label = label;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setLabel(String label) throws CannotAddLabelException {
        if(number == null || number.isEmpty()){
            throw new CannotAddLabelException("Can't add label without number. Please provide a number to add label!!");
        }
        else {
            this.label = label;
        }
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "country code='" + getCountryCode() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", label='" + getLabel() + '\'' +
                '}';
    }
}

package com.hcltech;

import java.io.Serializable;

public class Address implements Serializable {
        private String street;
        private String city;
        private String state;
        private String pinCode;
        private String country;
        private String label;

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public String toString() {
            return "Address{" +
                "street='" + getStreet() + '\'' +
                ", city='" + getCity() + '\'' +
                ", state='" + getState() + '\'' +
                ", pincode='" + getPinCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", label='" + getLabel() + '\'' +
                '}';
        }
}

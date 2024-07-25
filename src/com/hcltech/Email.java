package com.hcltech;

import java.io.Serializable;

public class Email implements Serializable {
    private String label;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email id='" + getEmail() + '\'' +
                ", label='" + getLabel() + '\'' +
                '}';
    }
}

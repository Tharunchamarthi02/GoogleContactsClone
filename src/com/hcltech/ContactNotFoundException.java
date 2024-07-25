package com.hcltech;

public class ContactNotFoundException extends Throwable {
    public ContactNotFoundException(String message) {
        super(message);
    }
}

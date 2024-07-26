package com.hcltech;

import java.util.Arrays;
import java.util.Scanner;

public class ContactHelper {
    ContactOperations contactOperations = new ContactDatabase();
    final Scanner scanner = new Scanner(System.in);
    public void addContacts() {
        Contact contact1 = new Contact();
        contact1.setFirstName("John");
        contact1.setLastName("");
        contact1.setNotes("Hello from Tharun");

        Contact contact2 = new Contact();
        contact2.setCompany("HCL");

        Address address1 = new Address();
        address1.setStreet("Church Street");
        address1.setCity("Bangalore");
        address1.setState("Karnataka");
        address1.setPinCode("12345");
        address1.setCountry("India");
        address1.setLabel("Home");

        Address address2 = new Address();
        address1.setStreet("Jigani link Road");
        address1.setCity("Bangalore");
        address1.setState("Karnataka");
        address1.setPinCode("23456");
        address1.setCountry("India");
        address1.setLabel("Work");

        contact2.setAddresses(Arrays.asList(address1, address2));

        Contact contact3 = new Contact();
        contact3.setFirstName("");

        try {
            contactOperations.addContact(contact1);
            contactOperations.addContact(contact2);
        }
        catch (ZeroFieldsException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void updateContact() throws ContactNotFoundException{
        System.out.println("Giving you the list of contacts - Please enter the id of the contact which you want to update.");
        showContacts();
        int id = scanner.nextInt();
        contactOperations.updateContacts(id);
    }

    public void showContacts(){
        contactOperations.getAllContacts();
    }

    public void deleteContact() throws ContactNotFoundException {
        System.out.println("Giving you the list of contacts - Please enter the id of the contact which you want to delete.");
        showContacts();
        int id = scanner.nextInt();
        contactOperations.deleteContact(id);
    }

    public void serializeContacts(){
        contactOperations.contactSerializer();
    }

    public void deserializeContacts(){
        contactOperations.contactDeserializer();
    }
}

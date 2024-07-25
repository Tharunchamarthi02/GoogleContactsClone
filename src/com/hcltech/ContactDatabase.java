package com.hcltech;

import java.io.*;
import java.util.*;

public class ContactDatabase implements ContactOperations{
    private Map<Integer, Contact> contacts = new HashMap<>();
    @Override
    public void addContact(Contact contact) throws ZeroFieldsException {
        if (contact.isValid()) {
            contacts.put(contact.getId(),contact);
        } else {
            throw new ZeroFieldsException("At least one field must be provided to create a contact");
        }
    }

    @Override
    public Contact getContact(int id) throws ContactNotFoundException {
        Contact contact = contacts.get(id);
        if (contact == null) {
            throw new ContactNotFoundException("Contact not found with id: " + id);
        }
        return contact;
    }

    @Override
    public void getAllContacts() {
        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            System.out.println(contact);
        }
    }

    @Override
    public void deleteContact(int id) throws ContactNotFoundException {
        Contact contact = contacts.remove(id);
        if (contact == null) {
            throw new ContactNotFoundException("Contact not found with id: " + id);
        }
        else {
            System.out.println("Contact deleted successfully!!");
        }
    }

    @Override
    public void updateContacts(int id) throws ContactNotFoundException{
            Contact toBeUpdated = getContact(id);
            toBeUpdated.setCompany("HCL");
            toBeUpdated.setTitle("Software Developer");
            try{
                PhoneNumber contactNumber1 = new PhoneNumber("+91","8978091266", "Home");
                PhoneNumber contactNumber2 = new PhoneNumber("+91","9999999999", "Work");
                toBeUpdated.setPhoneNumbers(Arrays.asList(contactNumber1,contactNumber2));
                PhoneNumber contactNumber3 = new PhoneNumber();
                contactNumber3.setLabel("Work");
                toBeUpdated.setPhoneNumbers(Arrays.asList(contactNumber3));
            }
            catch (CannotAddLabelException exception){
                System.out.println(exception.getMessage());
            }
    }

    @Override
    public void contactSerializer(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contacts.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
                Contact contact = entry.getValue();
                objectOutputStream.writeObject(contact);
            }
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch(FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void contactDeserializer() {
        try{
            FileInputStream fileInputStream = new FileInputStream("contacts.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while(true){
                Contact contact = (Contact) objectInputStream.readObject();
                contacts.put(contact.getId(),contact);
            }
        }
        catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        catch (IOException exception){
            //System.out.println(exception.getMessage());
        }
        catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }
}


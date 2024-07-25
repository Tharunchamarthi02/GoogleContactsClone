package com.hcltech;
import java.util.List;

public interface ContactOperations {
        void addContact(Contact contact) throws ZeroFieldsException;
        Contact getContact(int id) throws ContactNotFoundException;
        void getAllContacts();
        void deleteContact(int id) throws ContactNotFoundException;
        void updateContacts(int id) throws ContactNotFoundException;
        void contactSerializer();
        void contactDeserializer();
}


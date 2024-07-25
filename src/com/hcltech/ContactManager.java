package com.hcltech;

import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args)  {

        ContactHelper contactHelper = new ContactHelper();
        contactHelper.deserializeContacts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the operation you want to perform : ");
        boolean stop = false;
        while(!stop) {
            System.out.println("1.Add Contact\n2.Update Contact\n3.Show Contacts\n4.Delete Contact\n5.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    contactHelper.addContacts();
                    break;
                case 2:
                    try{
                        contactHelper.updateContact();
                    }
                    catch (ContactNotFoundException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 3:
                    contactHelper.showContacts();
                    break;
                case 4:
                    try{
                        contactHelper.deleteContact();
                    }
                    catch (ContactNotFoundException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("See you soon..!!");
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    stop = true;
            }
        }

        contactHelper.serializeContacts();
    }
}

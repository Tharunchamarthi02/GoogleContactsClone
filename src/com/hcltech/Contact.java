package com.hcltech;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {
        private int id;
        private static int count = 0;
        private String firstName;
        private String lastName;
        private List<PhoneNumber> phoneNumbers;
        private List<Email> emails;
        private List<Address> addresses;
        private String company;
        private String title;

        public Contact(){
            count++;
            setId(count);
        }

        public Contact(int id, String firstName, String lastName, List<PhoneNumber> phoneNumbers, List<Email> emails, List<Address> addresses, String company, String title ){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumbers = phoneNumbers;
            this.emails = emails;
            this.addresses = addresses;
            this.company = company;
            this.title = title;
        }

        public void setId(int count) {
             this.id = count;
        }

        public int getId() {
            return id;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        public List<PhoneNumber> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setEmails(List<Email> emails) {
            this.emails = emails;
        }

        public List<Email> getEmails() {
            return emails;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

    public boolean isValid() {
            return (firstName != null || lastName != null || phoneNumbers != null || emails != null || addresses != null || company != null || title != null );
        }

        public String toString() {
             return "Contact{" +
                "id='" + id + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumbers=" + getPhoneNumbers() +
                ", emails=" + getEmails() +
                ", addresses=" + getAddresses() +
                ", company='" + getCompany() + '\'' +
                ", title='" + getTitle() + '\'' +
                '}';
        }
}

package com.cnug.learn;

public class Contact {
    private String contactName;
    private long phoneNumber;


    public Contact(String contactName, long phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return contactName + ", " + phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

}

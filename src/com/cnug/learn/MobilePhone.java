package com.cnug.learn;

import java.util.ArrayList;

public class MobilePhone {

    private String phoneName;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private String[] phoneOptions = {"Print Options", "Print Contacts", "Add New Contact", "Update Contact", "Remove Contact",
                                    "Find Contact", "Quit"};

    public MobilePhone(String phoneName) {
        this.phoneName = phoneName;
        // default contact
        contacts.add(new Contact("C-Nug", 5555551234L));
    }

    public void printPhoneOptions() {
        System.out.println("Please select an option");
        for (int i = 0; i < phoneOptions.length; i++) {
            System.out.println("\t" + i + " - " + phoneOptions[i]);
        }
    }

    public boolean addContact(String name, long phoneNumber) {
        if (phoneNumber >= 1000000000L && phoneNumber < 10000000000L) {
            contacts.add(new Contact(name, phoneNumber));
            return true;
        } else {
            return false;
        }
    }

    public boolean editContact(int contactIndex, String name, long phoneNumber) {
        return removeContact(contactIndex) && addContact(name, phoneNumber);
    }

    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + " - " + contacts.get(i).toString());
        }
    }

    public boolean removeContact(int contactIndex) {
        if (contactIndex > 0 && contactIndex <= contacts.size()) {
            contacts.remove(contactIndex - 1);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(String contactName) {
        int indexOfFoundContact = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                indexOfFoundContact = i + 1;
                break;
            }
        }
        return indexOfFoundContact;
    }

    public String getPhoneName() {
        return phoneName;
    }

}

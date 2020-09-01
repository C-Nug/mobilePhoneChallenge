package com.cnug.learn;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("C-Nug's Phone");

    public static void main(String[] args) {

        System.out.println("\n***************************\n" +
                "Welcome to " + mobilePhone.getPhoneName() + "\n");
        mobilePhone.printPhoneOptions();
        boolean quit = false;
        int choice;

        while(!quit) {
            System.out.print("Enter option: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        mobilePhone.printContacts();
                        break;
                    case 2:
                        addContact();
                        break;
                    case 3:
                        updateContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        findContact();
                        break;
                    case 6:
                        quit = true;
                        System.out.println("Shutting down phone...");
                        break;
                    default:
                        mobilePhone.printPhoneOptions();
                        break;
                }
            } else {
                System.out.println("Choice must be a number");
                scanner.nextLine();
            }
        }
    }

    public static void addContact() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        boolean  isValidNumber = false;
        long phoneNumber = 0;
        while(!isValidNumber) {
            System.out.print("Enter a phone number: ");
            if(scanner.hasNextLong()) {
                phoneNumber = scanner.nextLong();
                isValidNumber = mobilePhone.addContact(contactName, phoneNumber);
            } if (!isValidNumber) {
                System.out.println("Invalid phone number.");
            }
            scanner.nextLine();
        }
        System.out.println("Contact added.");
    }

    public static void removeContact() {

        boolean validNumber = false;
        while(!validNumber) {
            System.out.println("Enter number of entry to remove: ");
            if (scanner.hasNextInt()) {
                int contactIndex = scanner.nextInt();
                validNumber = mobilePhone.removeContact(contactIndex);
            }
            if (!validNumber){
                System.out.println("Invalid number.");
            }
            scanner.nextLine();
        }
        System.out.println("Contact removed.");
    }

    public static void updateContact() {

        int contactIndex = 0;
        boolean validNumber = false;
        while(!validNumber) {
            System.out.println("Enter number of entry to edit: ");
            if (scanner.hasNextInt()) {
                contactIndex = scanner.nextInt();
                validNumber = true;
            } else {
                System.out.println("Invalid number.");
            }
            scanner.nextLine();
        }

        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        boolean isValidPhoneNumber = false;
        boolean isFirstLoop = true;
        long phoneNumber = 0;
        while(!isValidPhoneNumber) {
            System.out.print("Enter a phone number: ");
            if(scanner.hasNextLong() && isFirstLoop) {
                phoneNumber = scanner.nextLong();
                isValidPhoneNumber = mobilePhone.editContact(contactIndex, contactName, phoneNumber);
                isFirstLoop = false;
            }  else {
                phoneNumber = scanner.nextLong();
                isValidPhoneNumber = mobilePhone.addContact(contactName, phoneNumber);
            }
            if (!isValidPhoneNumber) {
                System.out.println("Invalid phone number.");
            }
            scanner.nextLine();
        }
        System.out.println("Contact added.");
    }

    public static void findContact() {
        System.out.println("Enter contact name to find: ");
        String contactName = scanner.nextLine();
        int indexOfContact = mobilePhone.findContact(contactName);
        if (indexOfContact >= 0) {
            System.out.println("Contact found at number " + indexOfContact + " .");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

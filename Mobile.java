/**
 * Write a description of class Mobile here.
 * This class is a child class of Gadget.java. Has one attribute: credit which assigned a number of minutes to make a phone call. This class generate a phone number and has a method to make a phone call and other to display 
 * Mobile information such as: type of gadget, credit, phone number.
 * @author (Constantin Matei)
 * @version (1.0 April 2024)
 */

import java.util.Random;
public class Mobile extends Gadget {
    private int credit;
    private String phoneNumber;
    // Constructor
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
        generatePhoneNumber();
    }
    // Generating a random phone number
    private void generatePhoneNumber() {
        Random rand = new Random();
        StringBuilder phoneNumberBuilder = new StringBuilder("07");
        for (int i = 0; i < 9; i++) {
            phoneNumberBuilder.append(rand.nextInt(10));
        }
        phoneNumber = phoneNumberBuilder.toString();
    }
    // Accessor method for retrieving the phone number of the mobile
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCredit() {
        return credit;
        }
    // Mutator method for setting the credit of the phone number (how many minutes cand talk with other phone numbers).
    public void setCredit(int credit) {
        this.credit = credit;
    }
    // Method for making a call with a specified phone number, duration and credit
        public void makeCall(String phoneNumber, int duration) {
        if (duration <= credit) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            credit -= duration;
            System.out.println("Remaining credit for " + phoneNumber + " is " + credit + " minutes.");
        } else {
            System.out.println("Insufficient credit to make the call.");
        }
    }
    // Method for displaying the characteristics of mobiles phone from gadget shop application
    @Override
    public void display() {
        super.display();
        System.out.println("Type of Gadget: Mobile");
        System.out.println("Credit: " + credit + " minutes");
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("******************************");
    }
}
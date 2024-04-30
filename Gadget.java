/**
 * Write a description of class Gadget here.
 * Gadget class is a java class with 4 common attributes: Model, Price, Weight and Size
 * Model and Size attributes are String data type, Price is double and Weight is integer
 * @author (Constantin Matei)
 * @version (1.0 April 2024)
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Gadget {
    // Protected fields
    protected String model;
    protected double price; // in pounds
    protected int weight; // in grams
    protected String size; // e.g. "71mm x 137mm x 9mm"

    // Static list to store gadgets
    protected static ArrayList<Gadget> gadgets;

    // Constructor
    public Gadget(String model, double price, int weight, String size) {
        try {
            if (model.matches("[0-9]+")) { // this condition specifies that if the name consists only of numbers to display an error message
                throw new IllegalArgumentException("Model name cannot consist only of numbers");
            }
            if (price < 0) { // this condition specifies that if the price is negative to display an error message
                throw new IllegalArgumentException("Price must be a non-negative value.");
            }
            if (weight < 0) { // this condition specifies that if the weight is negative to display an error message
                throw new IllegalArgumentException("Weight must be a non-negative value.");
            }
            this.model = model;
            this.price = price;
            this.weight = weight;
            this.size = size;
            // Initialize gadgets list if it's null
            if (gadgets == null) {
                gadgets = new ArrayList<>();
            }
            // Add the created gadget to the gadgets list
                gadgets.add(this);
            } catch (IllegalArgumentException act) {
                JOptionPane.showMessageDialog(null, act.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Accessor methods

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    // Display method
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }

    // Method to display all gadgets
    public static void displayAllGadgets() {
        if (gadgets.isEmpty()) {
            System.out.println("No gadgets added yet.");
            return;
        }
        System.out.println("List of gadgets:");
        for (Gadget gadget : gadgets) {
            gadget.display();
            System.out.println("--------------------");
        }
    }
}

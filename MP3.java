/**
 * Write a description of class MP3 here.
 * This class has one attribute: memory. MP3.java add MP3 player devices into ArrayList of Gadget and from GUI download some songs or you can increase the memory deleting some music. MP3.java is a child class of Gadget.java
 * @author (Constantin Matei)
 * @version (1.0 April 2024)
 */
public class MP3 extends Gadget {
    private double availableMemory;
    public MP3(String model, double price, int weight, String size, double memory) {
        super(model, price, weight, size); // Call superclass constructor first
        this.availableMemory = memory;
    }

    // Accessor method for availableMemory
    public double getAvailableMemory() {
        return availableMemory;
    }
    
    // Setter method for availableMemory
    public void setAvailableMemory(double availableMemory) {
        this.availableMemory = availableMemory;
    }
    // Method for downloading music
    public void downloadMusic(double musicSize) {
        if (musicSize <= availableMemory) {
            availableMemory -= musicSize;
            System.out.println("Music downloaded successfully. Available memory in MP3: " + availableMemory + " MB.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }
    
    // Method for deleting music and increase the available memory in this way
    public void deleteMusic(double musicSize) {
        availableMemory += musicSize;
        System.out.println("Music deleted successfully.");
        System.out.println("Available memory in MP3: " + availableMemory + " MB.");
    }
    
    // Method for displaying mp3 gadget
    @Override
    public void display() {
        super.display();
        System.out.println("Type of Gadget: MP3 Player");
        System.out.println("Available Memory: " + availableMemory + " MB");
        System.out.println("******************************");
    }    
}
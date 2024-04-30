/**
 * Write a description of class GadgetShop here.
 * This is a project for Coursework 3 at Programming. GadgetShop.java is the class that realizes the graphic interface of the entire project. According to the requirements, 
 * I will create the value input fields: model, price, weight, size, credit, memory. I will also create the buttons through which we will make the application functional. 
 * @author (Constantin Matei)
 * @version (1.0 April 2024)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {
    // Private fields. Create the frame of application, attributes: model, price, weight, size, credit, memory, call duration, size download, and display number
    // Create buttons for add 2 type of gadgets: Mobile and MP3 player, also create buttons for display gadgets, clear, make a call, download music, add credit and delete music.
    private JFrame frame;
    private JTextField model;
    private JTextField price;
    private JTextField weight;
    private JTextField size;
    private JTextField credit;
    private JTextField memory;
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JTextField phoneNumber;
    private JTextField callDuration;
    private JTextField sizeDownload;
    private JTextField displayNumber;
    private JButton makeACallButton;
    private JButton downloadMusicButton;
    private JButton deleteButton;
    private JButton addCreditButton;
    private ArrayList<Gadget> gadgets;

    public GadgetShop() {
        frame = new JFrame("GadgetShop");
        Container contentPane = frame.getContentPane();

        // We set a grid layout on 7 rows and 4 columns
        contentPane.setLayout(new GridLayout(7, 4, 2, 2));

        // Initialize gadgets ArrayList
        gadgets = new ArrayList<>();
        //Create input form for Model name
        model = new JTextField(12);
        contentPane.add(new JLabel("Model:"));
        price = new JTextField(12);
        contentPane.add(new JLabel("Price:"));
     
        weight = new JTextField(12);
        contentPane.add(new JLabel("Weight:"));

        size = new JTextField(12);
        contentPane.add(new JLabel("Size: H x W x T"));

        contentPane.add(model);
        contentPane.add(price);
        contentPane.add(weight);
        contentPane.add(size);

        memory = new JTextField(12);
        contentPane.add(new JLabel("Memory:"));

        credit = new JTextField(12);
        contentPane.add(new JLabel("Credit:"));
        
        //Create Add Mobile Butto
        addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(this);
        contentPane.add(addMobileButton);

        addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(this);
        contentPane.add(addMP3Button);

        contentPane.add(memory);
        contentPane.add(credit);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        contentPane.add(clearButton);

        displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(this);
        contentPane.add(displayAllButton);

        sizeDownload = new JTextField(12);
        contentPane.add(new JLabel("DNLD / DEL Size:"));

        phoneNumber = new JTextField(12);
        contentPane.add(new JLabel("Phone Number:"));

        callDuration = new JTextField(12);
        contentPane.add(new JLabel("Call Duration:"));

        displayNumber = new JTextField(2);
        contentPane.add(new JLabel("Display Number:"));

        contentPane.add(sizeDownload);        
        contentPane.add(phoneNumber);
        contentPane.add(callDuration);
        contentPane.add(displayNumber);

        downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(this);
        contentPane.add(downloadMusicButton);

        makeACallButton = new JButton("Make a Call");
        makeACallButton.addActionListener(this);
        contentPane.add(makeACallButton);
        
        deleteButton = new JButton("Delete Music");
        deleteButton.addActionListener(this);
        contentPane.add(deleteButton);
        
        addCreditButton = new JButton("Add credit");
        addCreditButton.addActionListener(this);
        contentPane.add(addCreditButton);      

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);
    }
    
    
    // Create Method for GUI with actionPerformed and ActionEvent
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == addMobileButton) {
                String gadgetModel = model.getText();
                String priceText = price.getText();
                String weightText = weight.getText();
                String gadgetSize = size.getText();
                String creditText = credit.getText();
                        if (gadgetModel.isEmpty() || priceText.isEmpty() || weightText.isEmpty() || gadgetSize.isEmpty() || creditText.isEmpty()) {
                    String errorMessage = "";
                    if (gadgetModel.isEmpty()) {
                        errorMessage += "Please input Model name.\n";
                    }
                    if (priceText.isEmpty()) {
                        errorMessage += "Please input price.\n";
                    }
                    if (weightText.isEmpty()) {
                        errorMessage += "Please input weight.\n";
                    }
                    if (gadgetSize.isEmpty()) {
                        errorMessage += "Please input size in format H x W x T.\n";
                    }
                    if (creditText.isEmpty()) {
                        errorMessage += "Please input credit.\n";
                    }
                    JOptionPane.showMessageDialog(frame, errorMessage);
                } else {
                    double gadgetPrice = Double.parseDouble(priceText);
                    int gadgetWeight = Integer.parseInt(weightText);
                    int gadgetCredit = Integer.parseInt(creditText);
                    // Create Mobile object and add it to the list
                    Mobile newMobile = new Mobile(gadgetModel, gadgetPrice, gadgetWeight, gadgetSize, gadgetCredit);
                    gadgets.add(newMobile);
                    JOptionPane.showMessageDialog(frame, "Mobile added successfully.");
                }
            } else if (event.getSource() == addMP3Button) {
                String gadgetModel = model.getText();
                String priceText = price.getText();
                String weightText = weight.getText();
                String gadgetSize = size.getText();
                String memoryText = memory.getText();
        
                if (gadgetModel.isEmpty() || priceText.isEmpty() || weightText.isEmpty() || gadgetSize.isEmpty() || memoryText.isEmpty()) {
                    String errorMessage = "";
                    if (gadgetModel.isEmpty()) {
                        errorMessage += "Please input Model name.\n";
                    }
                    if (priceText.isEmpty()) {
                        errorMessage += "Please input price.\n";
                    }
                    if (weightText.isEmpty()) {
                        errorMessage += "Please input weight.\n";
                    }
                    if (gadgetSize.isEmpty()) {
                        errorMessage += "Please input size in format H x W x T.\n";
                    }
                    if (memoryText.isEmpty()) {
                        errorMessage += "Please input memory.\n";
                    }
                    JOptionPane.showMessageDialog(frame, errorMessage);
                } else {
                    double gadgetPrice = Double.parseDouble(priceText);
                    int gadgetWeight = Integer.parseInt(weightText);
                    double gadgetMemory = Double.parseDouble(memoryText);
                    // Create MP3 object and add it to the list
                    MP3 newMP3 = new MP3(gadgetModel, gadgetPrice, gadgetWeight, gadgetSize, gadgetMemory);
                    gadgets.add(newMP3);
                    JOptionPane.showMessageDialog(frame, "MP3 added successfully.");
                }
            } else if (event.getSource() == displayAllButton) {
                // Print all gadgets
                displayAllGadgets();
                // Make a call. This Button when is pushed read a phone number take from credit minutes a number of minutes (call duration) and display remaining credit
            } else if (event.getSource() == makeACallButton) { 
                String phoneNumberText = phoneNumber.getText();
                String callDurationText = callDuration.getText();
                String displayNumberText = displayNumber.getText();
                String creditText = credit.getText();      
                if (phoneNumberText.isEmpty() || callDurationText.isEmpty() || displayNumberText.isEmpty() || creditText.isEmpty()) {
                    String errorMessage = "";
                    if (callDurationText.isEmpty()) {
                        errorMessage += "Please input call duration.\n";
                    }
                    if (phoneNumberText.isEmpty()) {
                        errorMessage += "Please input phone number.\n";
                    }
                    if (creditText.isEmpty()) {
                        errorMessage += "Please input credit.\n";
                    }
                    if (displayNumberText.isEmpty()) {
                        errorMessage += "Please input display number.\n";
                    }
                    JOptionPane.showMessageDialog(frame, errorMessage);
                } else {
                    int callDuration = Integer.parseInt(callDurationText);
                    int displayNumber = 0;
                    if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                        JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid index.");
                    } else {
                        Gadget gadget = gadgets.get(displayNumber);
                        if (gadget instanceof Mobile) {
                            Mobile mobileGadget = (Mobile) gadget;
                            String phoneNumber = mobileGadget.getPhoneNumber(); // Get phone number from the Mobile object
                             mobileGadget.makeCall(phoneNumber, callDuration); // Make the call using retrieved phone number
                        } else {
                            JOptionPane.showMessageDialog(frame, "The selected gadget is not a Mobile device.");
                        }
                    }
                } // Download Button. When the button is pushed MP3 player device take from memory some amount from memory and display the remaining available memory.
            } else if (event.getSource() == downloadMusicButton) {
            String sizeDownloadText = sizeDownload.getText();
            String displayNumberText = displayNumber.getText();
            String memoryText = memory.getText();                    
                if (sizeDownloadText.isEmpty() || displayNumberText.isEmpty() || (memoryText.isEmpty())) {
                    String errorMessage = "";
                    if (sizeDownloadText.isEmpty()) {
                        errorMessage += "Please input download size.\n";
                    }
                    if (displayNumberText.isEmpty()) {
                        errorMessage += "Please input Display Number.\n";
                    }
                    if (memoryText.isEmpty()) {
                        errorMessage += "Please input memory.\n";
                    }
                    JOptionPane.showMessageDialog(frame, errorMessage);
                } else {
                int displayNumber = Integer.parseInt(displayNumberText);
                double downloadSize = Double.parseDouble(sizeDownloadText);
                    if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                        JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid index.");
                } else {
                    Gadget gadget = gadgets.get(displayNumber);
                        if (gadget instanceof MP3) {
                        MP3 mp3Gadget = (MP3) gadget;
                        mp3Gadget.downloadMusic(downloadSize);
                        } else {
                        JOptionPane.showMessageDialog(frame, "The selected gadget is not an MP3 device.");
                    }
                }
            } //Delete Music. When this button is pushed the available memory is increased
        } else if(event.getSource() == deleteButton) {
            String sizeDownloadText = sizeDownload.getText();
            String displayNumberText = displayNumber.getText();
            String memoryText = memory.getText();                    
                if (sizeDownloadText.isEmpty() || displayNumberText.isEmpty() || (memoryText.isEmpty())) {
                    String errorMessage = "";
                    if (sizeDownloadText.isEmpty()) {
                        errorMessage += "Please input download size.\n";
                    }
                    if (displayNumberText.isEmpty()) {
                        errorMessage += "Please input Display Number.\n";
                    }
                    if (memoryText.isEmpty()) {
                        errorMessage += "Please input memory.\n";
                    }
                    JOptionPane.showMessageDialog(frame, errorMessage);
                } else {
                int displayNumber = Integer.parseInt(displayNumberText);
                double downloadSize = Double.parseDouble(sizeDownloadText);
                    if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                        JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid index.");
                } else {
                    Gadget gadget = gadgets.get(displayNumber);
                        if (gadget instanceof MP3) {
                        MP3 mp3Gadget = (MP3) gadget;
                        mp3Gadget.deleteMusic(downloadSize);
                        } else {
                        JOptionPane.showMessageDialog(frame, "The selected gadget is not an MP3 device.");
                    }
                }
            } 
        } else if (event.getSource() == clearButton) {
            model.setText(""); // Clear model field
            price.setText(""); // Clear price field
            weight.setText(""); // Clear weight field
            size.setText(""); // Clear size field
            credit.setText(""); // Clear credit field
            memory.setText(""); // Clear memory field
            sizeDownload.setText("");  // Clear download size field
            phoneNumber.setText(""); // Clear phone number field
            callDuration.setText(""); // Clear call duration field
            displayNumber.setText(""); // Clear display number field
            // Add Credit Button. This button increase the number of minutes of credit
        } else if (event.getSource() == addCreditButton) {
            String creditText = credit.getText();
            String displayNumberText = displayNumber.getText();
            if (creditText.isEmpty() || displayNumberText.isEmpty()) {
                String errorMessage = "";
                if (creditText.isEmpty()) {
                    errorMessage += "Please input credit.\n";
                }
                if (displayNumberText.isEmpty()) {
                    errorMessage += "Please input Display Number.\n";
                }
                JOptionPane.showMessageDialog(frame, errorMessage);
            } else {
                int displayNumber = Integer.parseInt(displayNumberText);
                int creditValue = Integer.parseInt(creditText);
                if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                    JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid index.");
                } else {
                    Gadget gadget = gadgets.get(displayNumber);
                    if (gadget instanceof Mobile) {
                        Mobile mobileGadget = (Mobile) gadget;
                        mobileGadget.setCredit(mobileGadget.getCredit() + creditValue);
                        JOptionPane.showMessageDialog(frame, "Credit added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "The selected gadget is not a Mobile device.");
                    }
                }
            }
        }
    } catch (NumberFormatException e) {
            if (event.getSource() == addMobileButton) {
                JOptionPane.showMessageDialog(frame, "Please input a valid number for price, weight and credit.");
            } else if (event.getSource() == addMP3Button) {
                JOptionPane.showMessageDialog(frame, "Please input a valid number for price, weight and memory.");
            } else if (event.getSource() == makeACallButton) {
                JOptionPane.showMessageDialog(frame, "Please input a valid number for call duration and credit.");
            } else if (event.getSource() == downloadMusicButton) {
                JOptionPane.showMessageDialog(frame, "Please input a valid number for download size and memory.");
            }
        }

    // Clear text fields after adding the gadget
    model.setText(""); 
    price.setText(""); 
    weight.setText(""); 
    size.setText(""); 
    credit.setText(""); 
    memory.setText(""); 
    sizeDownload.setText(""); 
    phoneNumber.setText(""); 
    callDuration.setText(""); 
    displayNumber.setText("");
    }
    // Method for displaying all gadgets
    private void displayAllGadgets() {
        for (Gadget gadget : gadgets) {
            gadget.display();
        }
    }
    // Method for running from terminal
    public static void main(String[] args) {
        new GadgetShop();
    }
}
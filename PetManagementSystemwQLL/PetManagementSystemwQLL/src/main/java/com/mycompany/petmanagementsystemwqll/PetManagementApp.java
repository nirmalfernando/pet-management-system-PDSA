/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petmanagementsystemwqll;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Pet {
//To represent pet properties
    int petID;
    String petName;
    String ownerName;
    int age;
    String petType;

    public Pet(int petID, String petName, String ownerName, int age, String petType) {
        this.petID = petID;
        this.petName = petName;
        this.ownerName = ownerName;
        this.age = age;
        this.petType = petType;
    }

    public String toString() {
        return "Pet ID: " + petID + ", Pet Name: " + petName + ", Owner's Name: " + ownerName
                + ", Age: " + age + ", Pet Type: " + petType;
    }
}

class Node {
//To represent a node in the Doubly linked list for storing pet objects
    Pet pet;
    Node next;
    Node prev;

    public Node(Pet pet) {
        this.pet = pet;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
//Implementing Doubly LinkedList data structure to manage pet objects
    Node head;

    public void addPet(Pet pet) { //To add a pet to the linkedlist
        Node newNode = new Node(pet);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void updatePet(int petID, Pet newPet) { //To update existing pet data in the linkedlist
        Node current = head;
        while (current != null) {
            if (current.pet.petID == petID) {
                current.pet = newPet;
                return;
            }
            current = current.next;
        }
    }

    public void deletePet(int petID) { //To delete an existing pet using the pet ID
        Node current = head;
        while (current != null) {
            if (current.pet.petID == petID) {
                if (current.prev == null) {
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public String printPets() { //To print pet details
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.pet.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    public Pet findPet(int petID) { //To find the pet with respective to its ID
        Node current = head;
        while (current != null) {
            if (current.pet.petID == petID) {
                return current.pet;
            }
            current = current.next;
        }
        return null;
    }
}
class apoiment {
//To represent appointment properties
    int petID;
    int apoimentid;
    String ownerName;
    LocalDateTime appointmentTime;
    

    public apoiment(int petID, int apoimentid, String ownerName,LocalDateTime appointmentTime) {
        this.petID = petID;
        this.apoimentid = apoimentid;
        this.ownerName = ownerName;
        this.appointmentTime = appointmentTime;
        
    }

    public String toString() {
        return "Pet ID: " + petID + ", Pet Name: " + apoimentid + ", Owner's Name: " + ownerName
                + ", Age: " + appointmentTime;
    }
}
class appoimrntnode {
//To represent a node in the Doubly linked list for storing appointment objects
    apoiment apoiment;
    appoimrntnode next;
    appoimrntnode prev;

    public appoimrntnode(apoiment apoiment) {
        this.apoiment = apoiment;
        this.next = null;
        this.prev = null;
    }
}
class apque {
//Implementing operations to add, print, and find appointments in a Doubly linked list
    appoimrntnode head;

    public void addapoinment(apoiment apoiment) {
        
        appoimrntnode newNode = new appoimrntnode(apoiment);
        if (head == null) {
            head = newNode;
        } else {
            appoimrntnode current = head;
            while (current.next != null) {
               current=current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public String printPets() {
        StringBuilder sb = new StringBuilder();
        appoimrntnode current = head;
        while (current != null) {
            sb.append(current.apoiment.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    public apoiment findapp(int petID) {
        appoimrntnode current = head;
        while (current != null) {
            if (current.apoiment.petID == petID) {
                return current.apoiment;
            }
            current = current.next;
        }
        return null;
    }
}


public class PetManagementApp extends JFrame implements ActionListener {
//GUI for the pet management application
    JTextField petIDField, petNameField, ownerNameField, ageField, petTypeField;
    JButton addButton, updateButton, deleteButton, printButton, scheduleButton, appointmentButton;
    JTextArea petDetailsArea;
    DoublyLinkedList petList;
    apque appointmentQueue;

    public PetManagementApp() {
        setTitle("Pet Management System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        add(new JLabel("Pet ID:"));
        petIDField = new JTextField();
        add(petIDField);

        add(new JLabel("Pet Name:"));
        petNameField = new JTextField();
        add(petNameField);

        add(new JLabel("Owner's Name:"));
        ownerNameField = new JTextField();
        add(ownerNameField);

        add(new JLabel("Pet's Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Pet's Type:"));
        petTypeField = new JTextField();
        add(petTypeField);

        addButton = new JButton("Add Pet");
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update Pet");
        updateButton.addActionListener(this);
        add(updateButton);

        deleteButton = new JButton("Delete Pet");
        deleteButton.addActionListener(this);
        add(deleteButton);

        printButton = new JButton("Print Pet Details");
        printButton.addActionListener(this);
        add(printButton);

        scheduleButton = new JButton("Schedule Appointment");
        scheduleButton.addActionListener(this);
        add(scheduleButton);
        
        appointmentButton = new JButton ("Appointment Details");
        appointmentButton.addActionListener(this);
        add(appointmentButton);

        petDetailsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(petDetailsArea);
        add(scrollPane);

        petList = new DoublyLinkedList();
        appointmentQueue = new apque();

        setVisible(true);
    }
appoimrntnode current;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) { //Adding pet details to the doubly linkedlist when the add button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            String petName = petNameField.getText();
            String ownerName = ownerNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String petType = petTypeField.getText();
            Pet newPet = new Pet(petID, petName, ownerName, age, petType);
            petList.addPet(newPet);
            petDetailsArea.setText(petList.printPets());
        } else if (e.getSource() == updateButton) { //Updating an existing pet detail in the linkedlist using pet ID when the update button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            String petName = petNameField.getText();
            String ownerName = ownerNameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String petType = petTypeField.getText();
            Pet updatedPet = new Pet(petID, petName, ownerName, age, petType);
            petList.updatePet(petID, updatedPet);
            petDetailsArea.setText(petList.printPets());
        } else if (e.getSource() == deleteButton) { //Deleting a pet data set from the linked list using pet ID when the delete button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            petList.deletePet(petID);
            petDetailsArea.setText(petList.printPets());
        } else if (e.getSource() == printButton) { //Redirecting to the pet details window to show pet details when the print button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            Pet pet = petList.findPet(petID);
            if (pet != null) {
                PetDetailsWindow petDetails = new PetDetailsWindow();
                petDetails.PetDetailsWindow(petList, petID);
                petDetails.show();
                this.hide();
            } else {
                JOptionPane.showMessageDialog(this, "Pet not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == scheduleButton) { //Scheduling an appointment and assigning an appointment ID to the pet ID when the schedule button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            String ownerName = ownerNameField.getText();
            LocalDateTime appointmentTime = LocalDateTime.now();
            if(appointmentQueue.head== null){
            apoiment newAppointment = new apoiment( petID, 1,ownerName,appointmentTime);
            appointmentQueue.addapoinment(newAppointment);
            JOptionPane.showMessageDialog(this, "Appointment scheduled for " + appointmentTime, "Information", JOptionPane.INFORMATION_MESSAGE);
            current = appointmentQueue.head;
            }
            else{
            
            apoiment newAppointment = new apoiment( petID,current.apoiment.apoimentid+1,ownerName,appointmentTime);
            appointmentQueue.addapoinment(newAppointment);
            JOptionPane.showMessageDialog(this, "Appointment scheduled for " + appointmentTime, "Information", JOptionPane.INFORMATION_MESSAGE);
            current = current.next;
            }
        } 
        else if (e.getSource() == appointmentButton) { //Redirecting to the appointment window to show appointment details when the appointment button is clicked
            int petID = Integer.parseInt(petIDField.getText());
            appDetailsWindow appointmentDetails = new appDetailsWindow();
            appointmentDetails.appDetailsWindow(appointmentQueue, petID);
        }
    }
    
    public static void main(String[] args) {
        new PetManagementApp();
    }
}

class PetDetailsWindow extends JFrame {
//GUI for the pet details showcasing window
    JLabel petIDLabel, petNameLabel, ownerNameLabel, ageLabel, petTypeLabel;
    Pet pets;
    int petId;

    public PetDetailsWindow() {
        setTitle("Pet Details");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        petIDLabel = new JLabel("Pet ID: ");
        add(petIDLabel);

        petNameLabel = new JLabel("Pet Name: ");
        add(petNameLabel);

        ownerNameLabel = new JLabel("Owner's Name: ");
        add(ownerNameLabel);

        ageLabel = new JLabel("Age: ");
        add(ageLabel);

        petTypeLabel = new JLabel("Pet Type: ");
        add(petTypeLabel);

        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousPet();
            }
        });
        add(previousButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextPet();
            }
        });
        add(nextButton);

        JButton returnButton = new JButton("Return to Main Form");
        returnButton.addActionListener(new ActionListener() { //Redirecting to the pet management application form
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                PetManagementApp petManagement = new PetManagementApp();
                petManagement.show();
            }
        });
        add(returnButton);

        setVisible(true);
    }

    DoublyLinkedList list;

    public void PetDetailsWindow(DoublyLinkedList petList, int petID) {
        list = petList;
        pets = list.findPet(petID);
        petId = petID;
        updateLabels();
    }

    private void showPreviousPet() { //Code to navigate to the previous pet's data
        if (petId > 0) {
            petId--;
            updateLabels();
        } else {
            JOptionPane.showMessageDialog(this, "No previous pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showNextPet() { //Code to navigate to the next pet's data
        try {
            if (petId > 0) {
                petId++;
                updateLabels();
            } else {
                JOptionPane.showMessageDialog(this, "No next pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No next pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateLabels() {
        pets = list.findPet(petId);
        petIDLabel.setText("Pet ID: " + pets.petID);
        petNameLabel.setText("Pet Name: " + pets.petName);
        ownerNameLabel.setText("Owner's Name: " + pets.ownerName);
        ageLabel.setText("Age: " + pets.age);
        petTypeLabel.setText("Pet Type: " + pets.petType);
    }
}
class appDetailsWindow extends JFrame {
//GUI for the appointment details showcasing window
    JLabel petIDLabel, petNameLabel, ownerNameLabel, ageLabel, petTypeLabel;
    Pet pets;
    int petId;

    public appDetailsWindow() {
        setTitle("Pet Details");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        petIDLabel = new JLabel("Pet ID: ");
        add(petIDLabel);

        petNameLabel = new JLabel("Pet Name: ");
        add(petNameLabel);

        ownerNameLabel = new JLabel("Owner's Name: ");
        add(ownerNameLabel);

        ageLabel = new JLabel("Age: ");
        add(ageLabel);

        petTypeLabel = new JLabel("Pet Type: ");
        add(petTypeLabel);

        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousap();
            }
        });
        add(previousButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextap();
            }
        });
        add(nextButton);

        JButton returnButton = new JButton("Return to Main Form");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hide();
                PetManagementApp petManagement = new PetManagementApp();
                petManagement.show();
            }
        });
        add(returnButton);

        setVisible(true);
    }

    apque list;
    apoiment ap;

    public void appDetailsWindow(apque petList, int petID) {
        list = petList;
        //ap = list.findapp(petID);
        petId = petID;
        updateLabels();
    }

    private void showPreviousap() { //Code to navigate to the previous appointment's data
        if (petId > 0) {
            petId--;
            updateLabels();
        } else {
            JOptionPane.showMessageDialog(this, "No previous pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showNextap() { //Code to navigate to the next appointment's data
        try {
            if (petId > 0) {
                petId++;
                updateLabels();
            } else {
                JOptionPane.showMessageDialog(this, "No next pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No next pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateLabels() {
        ap = list.findapp(petId);
        petIDLabel.setText("Pet ID: " + ap.petID);
        petNameLabel.setText("Appointment ID: " + ap.apoimentid);
        ownerNameLabel.setText("Owner's Name: " + ap.ownerName);
        ageLabel.setText("Appointment Time: " + ap.appointmentTime);
        petTypeLabel.setText("Pet Type: " + "");
    }
}



class PetDetailsWindow extends JFrame {

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

    DoublyLinkedList list;

    public void PetDetailsWindow(DoublyLinkedList petList, int petID) {
        list = petList;
        pets = list.findPet(petID);
        petId = petID;
        updateLabels();
    }

    private void showPreviousPet() {
        if (petId > 0) {
            petId--;
            updateLabels();
        } else {
            JOptionPane.showMessageDialog(this, "No previous pet available!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showNextPet() {
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
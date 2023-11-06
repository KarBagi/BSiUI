package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    JPanel mainPanel = new JPanel();
    JTextField writeField = new JTextField();
    JButton sendMessage = new JButton();
    JButton showConversations = new JButton();
    JLabel writeTextLabel = new JLabel();
    JLabel showContacts = new JLabel();
    JComboBox showConversation = new JComboBox();
    JTextField writeContact = new JTextField();
    JTable conversations = new JTable();

    String[] contacts = {"asd","asdasd","sdfsdf"};

    public void Window() {
        JFrame frame = new JFrame("Messenger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 330);

        writeTextLabel.setText("Write message to:");
        writeTextLabel.setBounds(5,10,120,20);

        writeContact.setBounds(125,10,100,20);

        sendMessage.setBounds(15, 240,150,30);
        sendMessage.setText("SEND MESSAGE");

        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("DONE");
            }
        });

        showConversations.setBounds(190,100, 150,30);
        showConversations.setText("Show conversation");

        showConversations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("WELL");
            }
        });

        writeField.setBounds(10, 30, 170, 200);
        writeField.setText("Write here");

        showConversation.setBounds(190,65,150,30);
        for(int i = 0; i < contacts.length; i++) {
            showConversation.addItem(contacts[i]);
        }

        showContacts.setText("Select conversation with");
        showContacts.setBounds(190, 35,150,30);

        conversations.setBounds(350,20,200,250);

        frame.add(writeField);
        frame.add(sendMessage);
        frame.add(writeTextLabel);
        frame.add(showConversations);
        frame.add(showConversation);
        frame.add(showContacts);
        frame.add(conversations);
        frame.add(writeContact);

        // Tworzenie przycisku
        /*JButton button = new JButton("Kliknij mnie");

        // Dodanie obsługi zdarzenia dla przycisku
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
            }
        });

        // Dodanie przycisku do panelu
        JPanel panel = new JPanel();
        panel.add(button);*/

        // Dodanie panelu do głównego okna

        // Wyświetlenie głównego okna

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

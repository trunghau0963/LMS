package com.lms.employee;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PublishersPage extends JFrame{
    private JPanel mainPanel;
    private CardLayout cardLayout;
    ListPublisherPanel publishers;
    AddPublisherPanel addPublisher;

    public PublishersPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        publishers = new ListPublisherPanel(cardLayout, mainPanel);
        addPublisher = new AddPublisherPanel(cardLayout, mainPanel);
        
        // Panel trống ban đầu
        mainPanel.add(publishers, "publishersPage");
        mainPanel.add(addPublisher, "addPublisher");
        getContentPane().add(mainPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new PublishersPage();
    }
}

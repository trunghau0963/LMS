package com.lms.employee.main;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.employee.AddPublisherPanel;
import com.lms.employee.ListPublisherPanel;

public class PublishersPage extends JPanel{
    private CardLayout cardLayout;
    ListPublisherPanel publishers;
    AddPublisherPanel addPublisher;

    public PublishersPage() {
        // Tạo CardLayout
        super();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        
        publishers = new ListPublisherPanel(cardLayout, this);
        addPublisher = new AddPublisherPanel(cardLayout, this);
        
        // Panel trống ban đầu
        this.add(publishers, "publishersPage");
        this.add(addPublisher, "addPublisher");
    }
}

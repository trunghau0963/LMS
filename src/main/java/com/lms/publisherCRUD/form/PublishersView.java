package com.lms.publisherCRUD.form;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.lms.publisherCRUD.form.other.AddPublisherPanel;
import com.lms.publisherCRUD.form.other.ListPublisherPanel;

public class PublishersView extends JPanel{
    private CardLayout cardLayout;
    ListPublisherPanel publishers;
    AddPublisherPanel addPublisher;

    public PublishersView() {
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

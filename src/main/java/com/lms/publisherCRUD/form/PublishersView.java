package com.lms.publisherCRUD.form;

import java.awt.CardLayout;
import javax.swing.JPanel;

import com.lms.publisherCRUD.repo.PublisherRepo;
import com.lms.publisherCRUD.dal.PublisherDao;
import com.lms.publisherCRUD.form.other.ListPublisherPanel;
import com.lms.publisherCRUD.form.other.temp.AddPublisherPanel;
import com.lms.publisherCRUD.service.PublisherService;

public class PublishersView extends JPanel {
    private CardLayout cardLayout;
    ListPublisherPanel publishers;
    AddPublisherPanel addPublisher;
    private PublisherService pubService;
    private PublisherDao pubDao;

    public PublishersView() {
        // Tạo CardLayout
        super();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        pubDao = PublisherRepo.getInstance();
        pubService = new PublisherService(pubDao);
        publishers = new ListPublisherPanel(pubService);

        // Panel trống ban đầu
        this.add(publishers, "publishersPage");
    }
}
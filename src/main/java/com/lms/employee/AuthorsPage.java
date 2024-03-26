package com.lms.employee;

import javax.swing.*;
import java.awt.*;

public class AuthorsPage extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    ListAuthorPanel authors;
    AddAuthorPanel addAuthor;
    EditInfoAuthorPanel editAuthor;

    public AuthorsPage() {
        
        setTitle("Author Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        authors = new ListAuthorPanel(cardLayout, mainPanel);
        addAuthor = new AddAuthorPanel(cardLayout, mainPanel);
        
        // Panel trống ban đầu
        mainPanel.add(authors, "authorsPage");
        mainPanel.add(addAuthor, "addAuthor");
        getContentPane().add(mainPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new AuthorsPage();
    }
}

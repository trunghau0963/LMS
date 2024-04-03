package com.lms.employee.main;

import javax.swing.*;

import com.lms.employee.AddAuthorPanel;
import com.lms.employee.EditInfoAuthorPanel;
import com.lms.employee.ListAuthorPanel;

import java.awt.*;

public class AuthorsPage extends JPanel {
    private CardLayout cardLayout;
    ListAuthorPanel authors;
    AddAuthorPanel addAuthor;
    EditInfoAuthorPanel editAuthor;

    public AuthorsPage() {
        // Tạo CardLayout
        super();

        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        authors = new ListAuthorPanel(cardLayout, this);
        addAuthor = new AddAuthorPanel(cardLayout, this);
        
        // Panel trống ban đầu
        this.add(authors, "authorsPage");
        this.add(addAuthor, "addAuthor");
    }
}

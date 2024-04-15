package com.lms.authorCRUD.form;

import javax.swing.*;

import com.lms.authorCRUD.form.other.AddAuthorPanel;
import com.lms.authorCRUD.form.other.EditInfoAuthorPanel;
import com.lms.authorCRUD.form.other.ListAuthorPanel;

import java.awt.*;

public class AuthorsView extends JPanel {
    private CardLayout cardLayout;
    ListAuthorPanel authors;
    AddAuthorPanel addAuthor;
    EditInfoAuthorPanel editAuthor;

    public AuthorsView() {
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

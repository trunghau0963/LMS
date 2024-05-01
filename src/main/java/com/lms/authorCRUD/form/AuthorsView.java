package com.lms.authorCRUD.form;

import java.awt.CardLayout;
import javax.swing.JPanel;

import com.lms.authorCRUD.repo.AuthorRepo;
import com.lms.authorCRUD.dal.AuthorDao;
import com.lms.authorCRUD.form.other.ListAuthorPanel;
import com.lms.authorCRUD.form.other.AddAuthorPanel;
import com.lms.authorCRUD.service.AuthorService;

public class AuthorsView extends JPanel {
    private CardLayout cardLayout;
    ListAuthorPanel authors;
    AddAuthorPanel addAuthor;
    private AuthorService authorService;
    private AuthorDao authorDao;

    public AuthorsView() {
        // Tạo CardLayout
        super();
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        authorDao = AuthorRepo.getInstance();
        authorService = new AuthorService(authorDao);
        authors = new ListAuthorPanel(authorService);
        
        // Panel trống ban đầu
        this.add(authors, "authorsPage");
    }
}
package com.lms.dataSaleCRUD.form.other;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.lms.dataSaleCRUD.dal.UserDao;
import com.lms.dataSaleCRUD.entities.BookWithRevenue;
import com.lms.dataSaleCRUD.repo.UserRepo;
import com.lms.dataSaleCRUD.service.UserService;

public class viewDataSaleBookPanel extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel panelParent;

    public viewDataSaleBookPanel(CardLayout cardLayout, JPanel panelParent) {
        this.cardLayout = cardLayout;
        this.panelParent = panelParent;
        initComponents();
        init();

    }

    private void init() {
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        // table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(125, 200, 204));
        table.getTableHeader().setForeground(new Color(0, 0, 0));

        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);
        List<BookWithRevenue> books = userService.getAllBooks();

        String[] columnNames = { "bookID", "title", "TotalRevenue" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // lấy dữ liệu cho bảng
        table.setModel(model);

        updateTable(books, model);

        // update bảng theo từ khóa tìm kiếm
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                filterByTitle();
            }

            public void removeUpdate(DocumentEvent e) {
                filterByTitle();
            }

            public void insertUpdate(DocumentEvent e) {
                filterByTitle();
            }
        });

        dateChooser1.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            if (dateChooser1.getDate() != null
                                    && dateChooser2.getDate() != null) {
                                filterByDate();
                            }
                        }
                    }
                });

        dateChooser2.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            if (dateChooser1.getDate() != null
                                    && dateChooser2.getDate() != null) {
                                filterByDate();
                            }
                        }
                    }
                });

        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTable(books, model);

                dateChooser1.setDate(null);
                dateChooser2.setDate(null);
            }
        });
    }

    public void filterByDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date startDate = dateChooser1.getDate();
        java.sql.Date tempDate1 = new java.sql.Date(startDate.getTime());
        String startDateString = formatter.format(tempDate1);

        java.util.Date endDate = dateChooser2.getDate();
        java.sql.Date tempDate2 = new java.sql.Date(endDate.getTime());
        String endDateString = formatter.format(tempDate2);

        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);

        List<BookWithRevenue> books = userService.getTotalRevenueGroupByBookBetweenDate(startDateString, endDateString);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        updateTable(books, model);
    }

    public void filterByTitle() {
        String filterText = jTextField1.getText();
        UserDao userDao = new UserRepo();
        UserService userService = new UserService(userDao);

        List<BookWithRevenue> books = userService.getAllBooks();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (BookWithRevenue book : books) {
            if (book.getTitle().toLowerCase().contains(filterText.toLowerCase())) {
                model.addRow(new Object[] { book.getBookId(), book.getTitle(), book.getTotal_revenue() });
            }
        }

    }

    public void updateTable(List<BookWithRevenue> books, DefaultTableModel model) {
        model.setRowCount(0);

        for (BookWithRevenue book : books) {
            model.addRow(new Object[] { book.getBookId(), book.getTitle(), book.getTotal_revenue()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        dateChooser2 = new com.toedter.calendar.JDateChooser();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        resetBtn = new com.lms.dataSaleCRUD.ui.Button();

        setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(800, 60));

        jPanel8.setPreferredSize(new java.awt.Dimension(100, 60));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel8.add(jComboBox1);

        jPanel3.add(jPanel8);

        jPanel6.setPreferredSize(new java.awt.Dimension(500, 60));

        jTextField1.setPreferredSize(new java.awt.Dimension(500, 40));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField1);

        jPanel3.add(jPanel6);

        jPanel5.setPreferredSize(new java.awt.Dimension(130, 60));

        dateChooser2.setPreferredSize(new java.awt.Dimension(110, 20));
        jPanel5.add(dateChooser2);

        dateChooser1.setPreferredSize(new java.awt.Dimension(110, 20));
        jPanel5.add(dateChooser1);

        jPanel3.add(jPanel5);

        jPanel9.add(jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Book Data Sale List");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 237, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 237, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel9.add(jPanel7);

        add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "bookId", "title", "TotalRevenue"
            }
        ));
        table.setRowHeight(30);
        table.setShowGrid(true);
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 20));

        returnButton.setText("Return");
        returnButton.setPreferredSize(new java.awt.Dimension(150, 40));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        jPanel4.add(returnButton);

        resetBtn.setBackground(new java.awt.Color(60, 58, 72));
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset Table");
        resetBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        jPanel4.add(resetBtn);

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        cardLayout.show(panelParent, "viewDataSalePanel");
    }//GEN-LAST:event_returnButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_resetBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser1;
    private com.toedter.calendar.JDateChooser dateChooser2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private com.lms.dataSaleCRUD.ui.Button resetBtn;
    private javax.swing.JButton returnButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

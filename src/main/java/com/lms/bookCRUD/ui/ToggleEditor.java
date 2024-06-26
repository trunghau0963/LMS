package com.lms.bookCRUD.ui;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import com.lms.bookCRUD.service.BookService;

import java.awt.*;

public class ToggleEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("");

    public ToggleEditor(BookService bookService, JTable table) {
        button.addActionListener(e -> {
            int rowSelected = table.getSelectedRow();
            if (rowSelected != -1) {
                String bookId = (String) table.getValueAt(rowSelected, 1);
                bookService.setBookVisibility(bookId, button.isSelected());
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Boolean) {
            button.setSelected((Boolean) value);
        } else {
            button.setSelected(false); // or handle this case differently
        }
        button.addActionListener(e -> stopCellEditing());

        return button;
    }

    // action preformed when the button is clicked

    @Override
    public Object getCellEditorValue() {
        return button.isSelected();
    }
}
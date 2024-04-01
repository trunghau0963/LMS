package com.lms.book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import java.awt.*;

public class TableToggleEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("");

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.addActionListener(e -> stopCellEditing());
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        BookJFrame.editBook.setBookId(tblModel.getValueAt(row, 0).toString());
        BookJFrame.editBook.loadBook();
        BookJFrame.showEditBook();
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.isSelected();
    }
}
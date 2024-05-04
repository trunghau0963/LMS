package com.lms.bookCRUD.ui;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import com.lms.bookCRUD.form.BookView;


public class EditToggleEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("");

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        if (value instanceof Boolean) {
            button.setSelected((Boolean) value);
        } else {
            button.setSelected(false); // or handle this case differently
        }
        button.addActionListener(e -> stopCellEditing());
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        BookView.loadEditBookPanel(tblModel.getValueAt(row, 0).toString());
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.isSelected();
    }
}
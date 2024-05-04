package com.lms.bookCRUD.ui;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableCellRenderer;

public class EditToggleRenderer implements TableCellRenderer {
    private JToggleButton button = new JToggleButton("");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value instanceof Boolean) {
            button.setSelected((Boolean) value);
        } else {
            button.setSelected(false); // or handle this case differently
        }
        button.setText("Edit");
        return button;
    }
}

package com.lms.book;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableToggleRenderer implements TableCellRenderer {
    private JToggleButton button = new JToggleButton("");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        button.setText("Edit");
        return button;
    }
}
package com.lms.categoryCRUD.SwitchButton;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ToggleRenderer implements TableCellRenderer {
    private JToggleButton button = new JToggleButton("");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value instanceof Boolean) {
            boolean temp = (Boolean) value;

            button.setSelected(temp);

            button.setText(temp ? "Hide" : "Show");
        } else {
            button.setSelected(false); // or handle this case differently
        }
        return button;
    }
}
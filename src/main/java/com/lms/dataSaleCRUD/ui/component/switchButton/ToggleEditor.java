package com.lms.dataSaleCRUD.ui.component.switchButton;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ToggleEditor extends AbstractCellEditor implements TableCellEditor {
    private JToggleButton button = new JToggleButton("false");

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

        @Override
        public Object getCellEditorValue() {
            return button.isSelected();
        }
}
package com.lms.employee.SwitchButton;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SwitchButtonRenderer extends SwitchButton implements TableCellRenderer {
    private Map<Integer, Boolean> switchButtonStates = new HashMap<>();

    public SwitchButtonRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (isSelected) {
            setSelected(!isSelected);
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
            System.out.println(isSelected + " " + row + " " + column + " " + value);
    
            setPreferredSize(new Dimension(50, 25));
        } 


        return this;
    }
}
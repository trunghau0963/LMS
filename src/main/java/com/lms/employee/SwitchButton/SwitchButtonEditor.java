package com.lms.employee.SwitchButton;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class SwitchButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private SwitchButton switchButton;

    public SwitchButtonEditor() {
        switchButton = new SwitchButton();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            System.out.println(isSelected + " " + row + " " + column);
            switchButton.setSelected(isSelected);
        } 

        return switchButton;
    }

    @Override
    public Object getCellEditorValue() {
        return switchButton.isSelected();
    }
}
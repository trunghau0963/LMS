package com.lms.dashboard.menu;
import java.awt.Color;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class Button extends javax.swing.JButton {
    private int index;
    private boolean selected = false;
    private boolean isLogoutButton = false;
    private static boolean enable = true;

    public Button(String name, int index) {
        super();
        setName(name);
        setIndex(index);
    }

    public Button(String name) {
        super();
        setName(name);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Button() {
        super();
    }

    public void setIcon(String icon) {
        setIcon(new FlatSVGIcon(icon));
    }

    public void setName(String name) {
        setText(name);
    }

    public String getName() {
        return getText();
    }

    public void setAction(java.awt.event.ActionListener action) {
        addActionListener(action);
    }

    public void setLogoutButton() {
        isLogoutButton = true;
    }

    public boolean isLogoutButton() {
        return isLogoutButton;
    }

    public static void setEnable(boolean enable) {
        Button.enable = enable;
    }

    public static boolean getEnable() {
        return enable;
    }

    public void setIconBackground(Color color) {
        setBackground(color);
    }

    public void setNameBackground(Color color) {
        setForeground(color);
    }

}

package com.lms.auth;

import java.awt.Font;
import java.io.IOException;

import javax.swing.UIManager;

import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class Main  {
    public static void main(String[] args) throws IOException {
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Button.arc", 10);

        // System.setProperty("flatlaf.menuBarEmbedded", "true");
        // System.setProperty("flatlaf.useDarkerBorder", "true");
        // System.setProperty("flatlaf.useDarkerScrollBar", "true");
        // System.setProperty("flatlaf.useDarkerPopupBorder", "true");
        // System.setProperty("flatlaf.useDarkerSeparator", "true");
        // System.setProperty("flatlaf.useDarkerFocusRing", "true");
        
        FlatMacDarkLaf.setup();
        
        Application frame = new Application();
        frame.setVisible(true);
        // frame.setLayout(new java.awt.BorderLayout());
    }
}

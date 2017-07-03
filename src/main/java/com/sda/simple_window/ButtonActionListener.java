package com.sda.simple_window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mytek on 2017-07-03.
 */
public class ButtonActionListener implements ActionListener {

    private JTextArea jTextArea;

    public ButtonActionListener(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jTextArea.append("kliknięto przycisk...\n");
    }
}

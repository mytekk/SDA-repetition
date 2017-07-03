package com.sda.simple_window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mytek on 2017-07-03.
 */
public class MainFrame extends JFrame {

    private JPanel jPanel;
    private JLabel jLabel;
    private JTextArea jTextArea;
    private JButton jButton;

    //konstruktor
    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.jPanel = new JPanel(new GridLayout(3, 1));
        this.jLabel = new JLabel("Witaj!");
        this.jTextArea = new JTextArea("Tekst początkowy");
        this.jButton = new JButton("Click me:)");

        jPanel.add(jLabel);
        jPanel.add(jTextArea);
        jPanel.add(jButton);

        jButton.addActionListener(new ButtonActionListener(jTextArea));

    }

    public void run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 300));

        this.getContentPane().add(jPanel);

        this.pack();
        this.setVisible(true);
    }
}

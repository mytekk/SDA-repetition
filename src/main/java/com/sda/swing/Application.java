package com.sda.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RENT on 2017-07-01.
 */
public class Application {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hello world!"); //tworzymy okienko w tytulem
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zamkniecie na krzyzyk

        JPanel jPanel = new JPanel(new GridLayout(3, 3)); //definicja panelu  z gridem 3x3

        JTextField jLabel = new JTextField("wregwef"); //nowa label
        JButton jButton = new JButton("Click me"); //przycisk, ktory po klknieciu zmienia tekst
        jButton.addActionListener(e -> {
            String text = jLabel.getText(); //pobierz text z label
            jButton.setText(text); //ustaw ten tekst na buttonie
            jLabel.setText(""); //wyczysc text w label
            jFrame.repaint(); //odswierzamy
        });

        JTextField jLabel2 = new JTextField("wregwef"); //nowa label
        JButton jButton2 = new JButton("Click me"); //przycisk, ktory po klknieciu zmienia tekst
        jButton2.addActionListener(e -> {
            String text = jLabel2.getText();
            jButton2.setText(text);
            jLabel2.setText("");
            jFrame.repaint();
        });

        JTextField jLabel3 = new JTextField("wregwef"); //nowa label
        JButton jButton3 = new JButton("Click me"); //przycisk, ktory po klknieciu zmienia tekst
        jButton3.addActionListener(e -> {
            String text = jLabel3.getText();
            jButton3.setText(text);
            jLabel3.setText("");
            jFrame.repaint();
        });

        jPanel.add(jLabel); //dodanie do panelu
        jPanel.add(jButton);

        jPanel.add(jLabel2); //dodanie do panelu
        jPanel.add(jButton2);

        jPanel.add(jLabel3); //dodanie do panelu
        jPanel.add(jButton3);


        jFrame.getContentPane().add(jPanel); //dodanie panelu do jframe
        jFrame.pack();
        jFrame.setVisible(true); //ustawiamy jako widoczne
    }
}

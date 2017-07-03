package com.sda.kik;

import com.sda.sockets.kik.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RENT on 2017-07-01.
 *
 * klasa pomocnicza rozszerzajaca klase ActionListener
 * tutaj, w metodzie actionPerformed, zdefiniowana jest akcja klikniecia przycisku przekazanego w konstruktorze
 */
public class KikButtonActionListener implements ActionListener {

    private Board board;
    private int position;
    private JButton jButton;
    private JPanel panel;
    private KikJFrameBoard jFrameBoard;

    public KikButtonActionListener(Board board, int position, JButton jButton, JPanel panel, KikJFrameBoard jFrameBoard) {
        this.board = board;
        this.position = position;
        this.jButton = jButton;
        this.panel = panel;
        this.jFrameBoard = jFrameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentSign = jFrameBoard.getCurrentSign();
        jButton.setText(currentSign);
        board.addMove(position+1, currentSign); //dodajemy pozycje do boardu
        System.out.println(board.toString()); //wypisanie boardu w konsoli
        jButton.setEnabled(false);
        jFrameBoard.setCurrentSign(currentSign.equals("X") ? "O" : "X"); //przy kliknieciu zmieniamy kolejny znak do wypisania na przeciwny

        //sprawdzenie
        if (board.isGameFinished()) {
            JOptionPane.showMessageDialog(null, "Koniec gry.");
            jFrameBoard.resetBoard();
        }

        panel.repaint();
    }
}

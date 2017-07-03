package com.sda.kik;

import com.sda.sockets.kik.Board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by RENT on 2017-07-01.
 *
 * klasa rozszerzajaca JFrame - zamiast tworzyć zmeinną typu JFrame tworzymy
 * wlasna klase, ktora rozszerza klase JFrame
 *
 * odpowiednik prostej aplikacji okienkowej jest tutaj rozbity:
 * 1) poczatek jest w konstruktorze naszej klasy
 * 2) dodawanie 9 przyciskow jest w pomocniczej funkcji initPanel wywoływanej w konstruktorze
 * 3) ustawienie pozostalych rzeczy (rozmiar, zamkniecie na krzyzyk) jka rowniez ustawienie widocznosci okienka
 * jest w metodzie run
 * 4) zdefiniowanie akcji klikniecia przyciskow wyniosione jest do klasy pomocniczej
 */
public class KikJFrameBoard extends JFrame {

    private Board board;

    private JPanel panel;

    private String currentSign;

    private List<JButton> buttons;

    //konstruktor
    public KikJFrameBoard() throws HeadlessException {
        super("Kolko i krzyzyk");
        this.board = new Board(); //tworzymy boarda
        this.panel = new JPanel(new GridLayout(3, 3)); //tworzymy panel
        this.currentSign = "X"; //zaczynamy od "X", potem co ruch bedziemy zmieniac na "O"
        this.buttons = new ArrayList<>();
        initPanel(); //tworzy zawartosc panelu
        this.getContentPane().add(panel); //dodajemy panel do ???
    }

    private void initPanel() {
        for (int i = 0; i < 9; i++) {
            int position = i;
            JButton jButton = new JButton(); //utwrzenie buttonu
            jButton.addActionListener( //akcja klikniecia
                    new KikButtonActionListener(board, position, jButton, panel, this));
            panel.add(jButton); //dodanie buttonu do panelu
            buttons.add(jButton); //dodanie buttonu do listy buttonow
        }
    }

    public String getCurrentSign() {
        return currentSign;
    }

    public void setCurrentSign(String currentSign) {
        this.currentSign = currentSign;
    }

    public void run() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 300));
        this.pack();
        this.setVisible(true);
    }

    public void resetBoard() {
        //resetowanie buttonow
        buttons.forEach(e -> {
            e.setEnabled(true);
            e.setText("");
        });
        //resetowanie boardu
        board.resetBoard();
        //current sign na nowo na "X"
        currentSign = "X";
    }
}

import javax.swing.*;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class memorycard extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;

    private final List<JButton> przyciski = new ArrayList<>();
    private final List<String> sciezkiKart = new ArrayList<>();

    private JButton pierwszaKarta = null;
    private JButton drugaKarta = null;
    private int indeksPierwszej = -1;
    private boolean blokadaKlikania = false;
    private int odgadnietePary = 0;
    private final int ROZMIAR = 95;
    private  int liczbaRuchow = 0;


    public memorycard() {
        initComponents();
        inicjalizujGre();
    }
    private void inicjalizujGre() {
        przyciski.add(button1);
        przyciski.add(button2);
        przyciski.add(button3);
        przyciski.add(button4);
        przyciski.add(button5);
        przyciski.add(button6);
        przyciski.add(button7);
        przyciski.add(button8);
        przyciski.add(button9);
        przyciski.add(button10);
        przyciski.add(button11);
        przyciski.add(button12);
        przyciski.add(button13);
        przyciski.add(button14);
        przyciski.add(button15);
        przyciski.add(button16);

        for (int i = 1; i <= 8; i++) {
            sciezkiKart.add("src/images/" + i + ".png");
            sciezkiKart.add("src/images/" + i + ".png");
        }

        Collections.shuffle(sciezkiKart);

        for (int i = 0; i < przyciski.size(); i++) {
            JButton btn = przyciski.get(i);
            btn.setText("");
            btn.setIcon(null);
            btn.setFocusPainted(false);

            final int indeks = i;
            btn.addActionListener(e -> klikniecieKarty(btn, indeks));
        }
    }
    private void klikniecieKarty(JButton kliknietyPrzycisk, int indeks) {
        if (blokadaKlikania || kliknietyPrzycisk == pierwszaKarta || kliknietyPrzycisk.getIcon() != null) {
            return;
        }
        ImageIcon ikonaZwierzecia = wczytajIPrzeskaluj(sciezkiKart.get(indeks), ROZMIAR, ROZMIAR);
        kliknietyPrzycisk.setIcon(ikonaZwierzecia);

        if (pierwszaKarta == null) {
            pierwszaKarta = kliknietyPrzycisk;
            indeksPierwszej = indeks;
        } else {
            drugaKarta = kliknietyPrzycisk;
            blokadaKlikania = true;
            liczbaRuchow++;

            if (sciezkiKart.get(indeksPierwszej).equals(sciezkiKart.get(indeks))) {
                pierwszaKarta.setEnabled(false);
                drugaKarta.setEnabled(false);
                odgadnietePary++;
                resetWyboru();

                if (odgadnietePary == 8) {
                    JOptionPane.showMessageDialog(this,
                            "Liczba ruchów: "+  liczbaRuchow);
                }
            } else {
                Timer timer = new Timer(750, ev -> {
                    pierwszaKarta.setIcon(null);
                    drugaKarta.setIcon(null);
                    resetWyboru();
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void resetWyboru() {
        pierwszaKarta = null;
        drugaKarta = null;
        indeksPierwszej = -1;
        blokadaKlikania = false;
    }

    private ImageIcon wczytajIPrzeskaluj(String sciezka, int w, int h) {
        File plik = new File(sciezka);
        if (plik.exists()) {
            ImageIcon icon = new ImageIcon(sciezka);
            Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } else {
            System.err.println("Nie znaleziono pliku: " + sciezka);
            return null;
        }
    }
    private void initComponents() {
        setTitle("Gra Memory - Zwierzęta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panelGry = new JPanel();
        panelGry.setLayout(new GridLayout(4, 4, 8, 8));
        panelGry.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();

        panelGry.add(button1);
        panelGry.add(button2);
        panelGry.add(button3);
        panelGry.add(button4);
        panelGry.add(button5);
        panelGry.add(button6);
        panelGry.add(button7);
        panelGry.add(button8);
        panelGry.add(button9);
        panelGry.add(button10);
        panelGry.add(button11);
        panelGry.add(button12);
        panelGry.add(button13);
        panelGry.add(button14);
        panelGry.add(button15);
        panelGry.add(button16);

        add(panelGry, BorderLayout.CENTER);
    }
    public class memory {
        private JButton button1;
        private JButton button2;
        private JButton button3;
        private JButton button4;
        private JButton button5;
        private JButton button6;
        private JButton button7;
        private JButton button8;
        private JButton button9;
        private JButton button10;
        private JButton button11;
        private JButton button12;
        private JButton button13;
        private JButton button14;
        private JButton button15;
        private JButton button16;
    }
}


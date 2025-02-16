package de.htwsaar.presentation.plPages;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListPageOne {

    JFrame frame = new JFrame();

    JLabel header = new JLabel("List One");

    public ListPageOne(){

        header.setBounds(180, 20, 200, 40);
        header.setFont(new Font(null, Font.ROMAN_BASELINE, 18));

        frame.setSize(480, 480);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        frame.add(header);

    }

    public void getList()
    {
        int id = 1;

    }
}
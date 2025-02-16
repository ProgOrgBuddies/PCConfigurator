package de.htwsaar.presentation.plPages;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListPageThree {

    JFrame frame = new JFrame();

    JLabel header = new JLabel("List Three");

    public ListPageThree(){

        header.setBounds(180, 20, 200, 40);
        header.setFont(new Font(null, Font.ROMAN_BASELINE, 18));

        frame.setSize(480, 480);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.add(header);

    }

}
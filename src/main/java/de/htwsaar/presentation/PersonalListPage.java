package de.htwsaar.presentation;

import de.htwsaar.presentation.plPages.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PersonalListPage {

    JFrame frame = new JFrame();

    JLabel headerLabel = new JLabel("Personal List");

    JButton list1Button = new JButton("empty");
    JButton list2Button = new JButton();
    JButton list3Button = new JButton();

    JButton deleteList1Button = new JButton();
    JButton deleteList2Button = new JButton();
    JButton deleteList3Button = new JButton();

    JButton returnButton = new JButton("Return to menu.");

    PersonalListPage(){

        Color lightBlue = new Color(51, 153, 255);
        ImageIcon icon = new ImageIcon("delete-32 (1).png");

        headerLabel.setBounds(260, 30, 200, 40);
        headerLabel.setFont(new Font(null, Font.BOLD, 25));

        deleteList1Button.setBounds(30, 150, 55, 55);
        deleteList1Button.setFocusable(false);
        deleteList1Button.setIcon(icon);

        deleteList2Button.setBounds(30, 230, 55, 55);
        deleteList2Button.setFocusable(false);
        deleteList2Button.setIcon(icon);

        deleteList3Button.setBounds(30, 310, 55, 55);
        deleteList3Button.setFocusable(false);
        deleteList3Button.setIcon(icon);

        list1Button.setBounds(120, 150, 400, 60);
        list1Button.setFocusable(false);
        list1Button.addActionListener(e -> {
            ListPageOne listPageOne = new ListPageOne();});
        list1Button.setFont(new Font("Arial", Font.BOLD, 18));
        list1Button.setForeground(Color.white);
        list1Button.setBackground(lightBlue);
        list1Button.setFocusPainted(false);
        list1Button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        list2Button.setBounds(120, 230, 400, 60);
        list2Button.setFocusable(false);
        list2Button.addActionListener(e -> {ListPageTwo listPageTwo = new ListPageTwo();});
        list2Button.setFont(new Font("Arial", Font.BOLD, 18));

        list3Button.setBounds(120, 310, 400, 60);
        list3Button.addActionListener(e -> {ListPageThree listPageThree = new ListPageThree();});
        list3Button.setFont(new Font("Arial", Font.BOLD, 18));

        returnButton.setBounds(390, 470, 200, 40);
        returnButton.addActionListener(e -> {
            GUI GUI = new GUI(); frame.dispose();});

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.add(headerLabel);
        frame.add(deleteList1Button);
        frame.add(deleteList2Button);
        frame.add(deleteList3Button);
        frame.add(list1Button);
        frame.add(list2Button);
        frame.add(list3Button);
        frame.add(returnButton);

    }

}
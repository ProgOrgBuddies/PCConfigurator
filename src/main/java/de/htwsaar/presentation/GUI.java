package de.htwsaar.presentation;

import de.htwsaar.servicelayer.Logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI  implements ActionListener {

    JFrame frame = new JFrame();

    JButton createListButton = new JButton("Create list.");
    JButton readListButton = new JButton("Personal list.");
    JButton leaveButton = new JButton("Leave program.");


    JLabel label = new JLabel("PC Configurator");

    Logic logic;


    public void start() {


        label.setBounds(115, 20, 200, 40);
        label.setFont(new Font(null, Font.PLAIN, 25));

        createListButton.setBounds(100, 100, 200, 40);
        createListButton.setFocusable(false);
        createListButton.addActionListener(this);

        readListButton.setBounds(100, 160, 200, 40);
        readListButton.setFocusable(false);
        readListButton.addActionListener(this);

        leaveButton.setBounds(100, 300, 200, 40);
        leaveButton.setFocusable(false);
        leaveButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(label);
        frame.add(createListButton);
        frame.add(readListButton);
        frame.add(leaveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==createListButton) {
            frame.dispose();
            CreatePersonalListMenu createPersonalListMenu = new CreatePersonalListMenu();
        }

        if (e.getSource()==readListButton){
            frame.dispose();
            PersonalListPage personalListPage = new PersonalListPage();
        }

        if (e.getSource()==leaveButton){
            frame.dispose();
        }

    }

}
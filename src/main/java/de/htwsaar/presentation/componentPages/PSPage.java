package de.htwsaar.presentation.componentPages;

import de.htwsaar.presentation.CreatePersonalListMenu;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PSPage {

    String SelectedComponent = "";
    CreatePersonalListMenu createPersonalListMenu;

    JFrame frame = new JFrame();

    JLabel label = new JLabel("Choose your power supply: ");
    JLabel compLabel = new JLabel();

    JButton addButton = new JButton("Add");

    public PSPage(CreatePersonalListMenu createPersonalListMenu){

        this.createPersonalListMenu = createPersonalListMenu;

        String[] ps = new String[8];
        ps[0] = "1";
        ps[1] = "2";
        ps[2] = "3";
        ps[3] = "4";
        ps[4] = "5";
        ps[5] = "6";
        ps[6] = "7";
        ps[7] = "8";

        label.setBounds(40, 30, 300, 40);
        label.setFont(new Font(null, Font.PLAIN, 25));
        compLabel.setBounds(40, 500, 300, 40);
        compLabel.setFont(new Font(null, Font.PLAIN, 20));

        JList<String> list = new JList<>(ps);
        list.setVisibleRowCount(25);

        JScrollPane jcp = new JScrollPane(list);
        jcp.setBounds(40, 120, 500, 350);

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                SelectedComponent = list.getSelectedValue();
                compLabel.setText(SelectedComponent);

            }

        });

        addButton.setBounds(550, 500, 100, 30);
        addButton.setFocusable(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!SelectedComponent.isEmpty()) {

                    createPersonalListMenu.updateLabel("ps", SelectedComponent);

                }

                frame.dispose();

            }
        });

        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocation(820, 0);
        frame.setLayout(null);
        frame.add(label);
        frame.add(compLabel);
        frame.add(addButton);
        frame.add(jcp);

    }

}
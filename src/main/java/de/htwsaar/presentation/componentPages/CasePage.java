package de.htwsaar.presentation.componentPages;

import de.htwsaar.presentation.CreatePersonalListMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CasePage {

    String SelectedComponent = "";

    CreatePersonalListMenu createPersonalListMenu;

    JFrame frame = new JFrame();

    JLabel label = new JLabel("Choose your case: ");
    JLabel compLabel = new JLabel();

    JButton addButton = new JButton("Add");

    public CasePage(CreatePersonalListMenu createPersonalListMenu){

        this.createPersonalListMenu = createPersonalListMenu;

        String[] pcCase = new String[8];
        pcCase[0] = "1";
        pcCase[1] = "2";
        pcCase[2] = "3";
        pcCase[3] = "4";
        pcCase[4] = "5";
        pcCase[5] = "6";
        pcCase[6] = "7";
        pcCase[7] = "8";

        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocation(820, 0);
        frame.setLayout(null);

        label.setBounds(40, 30, 300, 40);
        label.setFont(new Font(null, Font.PLAIN, 25));
        compLabel.setBounds(40, 500, 300, 40);
        compLabel.setFont(new Font(null, Font.PLAIN, 20));

        JList<String> list = new JList<>(pcCase);
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

                    createPersonalListMenu.updateLabel("case", SelectedComponent);

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
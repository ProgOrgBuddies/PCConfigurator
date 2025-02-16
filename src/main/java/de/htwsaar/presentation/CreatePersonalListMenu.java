package de.htwsaar.presentation;

import de.htwsaar.presentation.componentPages.*;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CreatePersonalListMenu {

    JFrame frame = new JFrame();

    JLabel menuLabel = new JLabel("Configurator MENU");
    JLabel componentLabel = new JLabel("Choose components: ");
    JLabel cpuLabel = new JLabel("Selected: ");
    JLabel gpuLabel = new JLabel("Selected: ");
    JLabel ramLabel = new JLabel("Selected: ");
    JLabel mainboardLabel = new JLabel("Selected: ");
    JLabel caseLabel = new JLabel("Selected: ");
    JLabel powerLabel = new JLabel("Selected: ");

    JButton cpuButton = new JButton("CPU: ");
    JButton gpuButton = new JButton("GPU: ");
    JButton ramButton = new JButton("RAM: ");
    JButton mainboardButton = new JButton("Mainboard: ");
    JButton caseButton = new JButton("Case: ");
    JButton powersupplyButton = new JButton("Power: ");
    JButton saveButton = new JButton("Save list.");
    JButton returnButton = new JButton("Return to menu.");


    CreatePersonalListMenu(){

        menuLabel.setBounds(300, 30, 400, 40);
        menuLabel.setFont(new Font(null, Font.PLAIN, 25));

        cpuLabel.setBounds(180, 120, 400, 40);
        cpuLabel.setFont(new Font(null, Font.PLAIN, 18));

        gpuLabel.setBounds(180, 180, 400, 40);
        gpuLabel.setFont(new Font(null, Font.PLAIN, 18));

        ramLabel.setBounds(180, 240, 400, 40);
        ramLabel.setFont(new Font(null, Font.PLAIN, 18));

        mainboardLabel.setBounds(180, 300, 400, 40);
        mainboardLabel.setFont(new Font(null, Font.PLAIN, 18));

        caseLabel.setBounds(180, 360, 400, 40);
        caseLabel.setFont(new Font(null, Font.PLAIN, 18));

        powerLabel.setBounds(180, 420, 400, 40);
        powerLabel.setFont(new Font(null, Font.PLAIN, 18));

        cpuButton.setBounds(40, 120, 100, 40);
        cpuButton.setFocusable(false);
        cpuButton.addActionListener(e -> {new CPUPage(this);});

        gpuButton.setBounds(40, 180, 100, 40);
        gpuButton.setFocusable(false);
        gpuButton.addActionListener(e -> {new GPUPage(this);});

        ramButton.setBounds(40, 240, 100, 40);
        ramButton.setFocusable(false);
        ramButton.addActionListener(e -> {new RAMPage(this);});

        mainboardButton.setBounds(40, 300, 100, 40);
        mainboardButton.setFocusable(false);
        mainboardButton.addActionListener(e -> {new MBPage(this);});

        caseButton.setBounds(40, 360, 100, 40);
        caseButton.setFocusable(false);
        caseButton.addActionListener(e -> {new CasePage(this);});

        powersupplyButton.setBounds(40, 420, 100, 40);
        powersupplyButton.setFocusable(false);
        powersupplyButton.addActionListener(e -> {new PSPage(this);});

        returnButton.setBounds(560, 680, 200, 40);
        returnButton.setFocusable(false);
        returnButton.addActionListener(e -> {
            frame.dispose();});

        saveButton.setBounds(40, 680, 200, 40);
        saveButton.setFocusable(false);
        saveButton.addActionListener(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.add(menuLabel);
        frame.add(componentLabel);
        frame.add(cpuLabel);
        frame.add(gpuLabel);
        frame.add(ramLabel);
        frame.add(mainboardLabel);
        frame.add(caseLabel);
        frame.add(powerLabel);

        frame.add(cpuButton);
        frame.add(gpuButton);
        frame.add(ramButton);
        frame.add(mainboardButton);
        frame.add(caseButton);
        frame.add(powersupplyButton);
        frame.add(returnButton);
        frame.add(saveButton);

    }

    public void updateLabel(String component, String newText){
        switch (component) {
            case "CPU":
                cpuLabel.setText("Selected: "+ newText);
                break;
            case "GPU":
                gpuLabel.setText("Selected: "+newText);
                break;
            case "case":
                caseLabel.setText("Selected: "+newText);
                break;
            case "mainboard":
                mainboardLabel.setText("Selected: "+newText);
                break;
            case "ps":
                powerLabel.setText("Selected: "+newText);
                break;
            case "RAM":
                ramLabel.setText("Selected: "+newText);
                break;
        }
    }
    // Save-Methode implementieren die wenn Liste vollständig und Save-Knopf gedrückt wird mir die Integer-Values von jeder ID von jeder Komponente returned


}
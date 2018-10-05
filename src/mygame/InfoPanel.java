/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel provides the user with a brief how-to for this game.
 * @author rustyblewitt
 */
public class InfoPanel extends JPanel{
    /*
        Constructor takes panel size as param
    */
    public InfoPanel(Dimension size){  
        setSize(size);
        setBackground(Color.WHITE);
        setPreferredSize(size);
        
        // Create Start button, set it's preferred size
        JButton gotItBtn = new JButton("Got it");
        gotItBtn.setPreferredSize(new Dimension(200, 60));
        gotItBtn.addActionListener(new GotItButtonListener());
        
        // Create instruction label with html markup
        JLabel instructionLabel = new JLabel(
                "<html><h1>Watch, memorise then input</h1></html>"
        );
        
        // Choose GridBagLayout as layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(instructionLabel, gbc);
       
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTH;
        add(gotItBtn, gbc);
        
        System.out.println("InfoPanel has been constructed");
    }
}

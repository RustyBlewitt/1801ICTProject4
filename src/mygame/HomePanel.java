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
 * This is the first panel users see, displaying game title and author.
 * @author rustyblewitt
 */
public class HomePanel extends JPanel{
    
    /*
        Constructor takes panel size as param
    */
    public HomePanel(Dimension size){ 
        setSize(size);
        setBackground(Color.WHITE);
        setPreferredSize(size);
        
        // Create Start button, set it's preferred size
        JButton startBtn = new JButton("Start");
        startBtn.setPreferredSize(new Dimension(200, 60));
        startBtn.addActionListener(new StartButtonListener());
        
        // Create title label with html markup
        JLabel titleLabel = new JLabel(
                "<html><h1 style=\"color:grey; text-align: center;\">"
                        + "Rusty Blewitt<br>s5131071<br>Memory Test</h1></html>"
        );
        
        // Choose GridBagLayout as layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(titleLabel, gbc);
       
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTH;
        add(startBtn, gbc);
        
        System.out.println("HomePanel has been constructed");
    }
    
}

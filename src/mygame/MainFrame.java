/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the JFrame where all panels will be displayed in.
 * @author rustyblewitt
 */
public class MainFrame extends JFrame{
    Container contentPane = new Container();
    // My constructor
    public MainFrame(String title){
        // Call the JFrame's constructor with 'title'
        super(title);
        // Set default close op
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create instance of HomePanel
        Dimension panelSize = new Dimension(500, 600);
        HomePanel homePanel = new HomePanel(panelSize);
        setLayout(new BorderLayout());
        setContentPane(homePanel);
        
        System.out.println("MainFrame constructor has been called");
    }    
    
    
}

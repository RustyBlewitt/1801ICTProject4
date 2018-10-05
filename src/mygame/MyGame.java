/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MyGame is the main class of this program. Main frame is initialised here
 * and switch panel functionality is also defined within this class.
 * @author rustyblewitt
 */
public class MyGame {

    /**
     * @param args the command line arguments
     */
    
    private static JFrame mainFrame;
    
    public static void main(String[] args) {
        // Create frame object titled "Random Game"
        mainFrame = new MainFrame("Random Game");
        // Make visible
        mainFrame.setVisible(true);
        // Program close on frame exit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set size
        mainFrame.setSize(500,600);
        
    }
    
    public static void goToPanel(JPanel pan){
        mainFrame.setContentPane(pan);
        System.out.println(pan);
        mainFrame.pack();
    }
    
}
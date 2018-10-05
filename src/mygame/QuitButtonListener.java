/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A listener that is attached to the 'quit' button in the game over panel.
 * @author rustyblewitt
 * On click of 'quit' button results in system exit.
 */
public class QuitButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}

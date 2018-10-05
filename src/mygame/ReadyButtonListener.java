/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A listener that is attached to the 'Replay' button inside the game over panel.
 * @author rustyblewitt
 */
public class ReadyButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ready button pressed");
    }
}

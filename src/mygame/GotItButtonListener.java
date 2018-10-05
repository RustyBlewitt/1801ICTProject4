/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static mygame.MyGame.goToPanel;

/**
 * A listener that is attached to the 'got it' button inside the info panel.
 * @author rustyblewitt
 *
 * On click, a new game panel is created.
 */
public class GotItButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        goToPanel(new GamePanel(new Dimension(500, 600)));
        System.out.println("Got it button pressed");
    }
    
}

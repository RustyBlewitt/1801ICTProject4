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
 * A listener that is attached to the 'replay' button inside the game over panel.
 * @author rustyblewitt
 * On click, level is set back to 1 and a new game panel is created.
 */
public class ReplayButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        GamePanel.level = 1;
        goToPanel(new GamePanel(new Dimension(500, 600)));
    }
    
}

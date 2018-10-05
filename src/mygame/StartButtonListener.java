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
 * A listener that is attached to the 'start' button inside the home panel.
 * On click, the info panel will be displayed
 * @author rustyblewitt
 */
public class StartButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("Start button has been pressed");
            InfoPanel mgPanel = new InfoPanel(new Dimension(500,600));
            goToPanel(mgPanel);
    }
}
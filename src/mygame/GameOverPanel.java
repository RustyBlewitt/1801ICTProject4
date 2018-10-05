/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static mygame.GamePanel.level;

/**
 * Notifies user that game is over, offering replay and quit options
 * @author rustyblewitt
 */
public class GameOverPanel extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();

    public GameOverPanel(Dimension size) {
        setPreferredSize(size);
        // Choose GridBagLayout as layout manager
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JLabel gameOverLab = new JLabel("<html><h1 style = \"color: red;"
                + "text-align: center;\">Game Over<br>"
                + "You reached Level " + level, SwingConstants.CENTER);
        gameOverLab.setSize(new Dimension(300, 300));

        JButton replayBtn = new JButton("Replay");
        replayBtn.addActionListener(new ReplayButtonListener());
        replayBtn.setSize(new Dimension(400, 60));

        JButton quitBtn = new JButton("Quit");
        quitBtn.addActionListener(new QuitButtonListener());
        quitBtn.setSize(new Dimension(400, 60));

        add(gameOverLab, gbc);
        
        gbc.gridy = 1;
        add(replayBtn, gbc);
        gbc.gridy = 2;
        add(quitBtn, gbc);
    }

}

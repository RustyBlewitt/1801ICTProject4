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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.util.LinkedList;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import static mygame.MyGame.goToPanel;


/**
 * Game Panel is where the main gameplay will take place.
 * This panel is re-initialised each level as the only changes in gameplay
 * refer to the following static methods that this class contains:
 *      - public static int level; 
 *          Increments when the fifo is emptied via successful key inputs.
 * 
 *      - public static LinkedList type: Integer fifo;
 *          This linked list is filled and emptied as levels begin and are
 *          worked through.
 * 
 *      - public static boolean keysBlocked;
 *          A boolean that allows / disallows key input.
 *          
 * @author rustyblewitt
 */
public class GamePanel extends JPanel{

    public static int level = 1;
    
    public static LinkedList<Integer> fifo = new LinkedList<Integer>();
    
    public static boolean keysBlocked = true;
    
    // Testing it out here    
    GridBagConstraints gbc = new GridBagConstraints();
    
    /*
        Constructor takes panel size as param
    */
    
    public GamePanel(Dimension size){ 
        
        fifo.clear();
        
        // Choose GridBagLayout as layout manager
        setLayout(new GridBagLayout());
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel levelLab = new JLabel("<html><h1>Level "
                + Integer.toString(level) + "</h1></html>", 
        SwingConstants.CENTER);
        levelLab.setPreferredSize(new Dimension(200, 60));
        
        // Ready Button Listener is not cooperating
        

        add(levelLab, gbc);

        setSize(size);
        setBackground(Color.WHITE);
        setPreferredSize(size);
        setFocusable(true);
        
        setKeyBindings();
        
        // Create title label with html markup
        JLabel info = new JLabel(
                "<html><h3 style=\"color:grey; text-align: right;\">"
                        + "Use keyboard to re-enter digits"
        );
       
        
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
       
        // Where numbers display
        gbc.gridy = 1;
        
        
        
        
        System.out.println("GamePanel has been constructed");
        
                
        for(int i = 0; i < level + 5; i++){
             // Random num generation
            int x = (int)(Math.random()*10);
            
            Timer timer = new Timer(( (i+1) * 1000),  new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    System.out.println(x);
                    fifo.add(x);
                    displayer(x, false);
                }
            });
            
            Timer timer2 = new Timer(( i * 1000 + 800),  new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    displayer("clear");
                }
            });
            
            timer.setRepeats(false);
            timer2.setRepeats(false);
            timer.start();
            timer2.start();
            
            // If last
            if(i == level + 4){
                Timer timer3 = new Timer(( (i+1) * 1000 + 800),  new ActionListener(){
                        public void actionPerformed(ActionEvent evt){
                            displayer("clear");
                            keysBlocked = false;
                            // Bottom screen info
                            gbc.gridy = 2;
                            gbc.anchor = GridBagConstraints.SOUTH;
                            add(info, gbc);
                        }
                    });
                timer3.setRepeats(false);
                timer3.start();
            }
                       
        }
        
    } 
    
    
    // Set up all key bindings for keyboard digit input
    private void setKeyBindings(){
        Action a = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent evt){
                System.out.println("This was clicked: " + evt.getActionCommand());
                int x  = evt.getActionCommand().charAt(0);
                if(keysBlocked == false){
                    displayer(x - 48, true);
                }
            }
        };
        //  For all digits register in inputmap and action map
        for(int i = 0; i < 10; i++){
            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    KeyStroke.getKeyStroke(""+i+""), ""+i+""
            );
            this.getActionMap().put(""+i+"", a);
        }
    }
    
    private void displayer(String action){
        JLabel label = new JLabel(
                "<html><h1 style = \"color: green; text-align: center;"
                        + "background: white; \">"+action+"</h1></html>"
            );
        if(action.equals("clear")){
            label = new JLabel(
                "<html><h1 style = \"color: white; background: white;"
                        + " \">clearing everything</h1></html>"
            );
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label, gbc);
        this.setComponentZOrder(label, 0);
        revalidate();
    }
    
    private void displayer(int x, boolean input){
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel num = new JLabel(
            "<html><h1 style = \"color: black; "
                    + "background: white;\">"+x+"</h1></html>"
        );
        if(input){
            num = new JLabel(
            "<html><h1 style = \"color: green; "
                    + "background: white;\">"+x+"</h1></html>"
        );
        }
        add(num, gbc);
        // Layer new digit on top of old
        this.setComponentZOrder(num, 0);
        revalidate();
        
        if(input){
            if(x != fifo.removeFirst()){
                System.out.println("Innnncorrect");
                GameOver();
            }
            
            if(fifo.size() == 0){
                // Repopulate numbers
                level += 1;
                displayer("Level Complete<br>Get Ready");
                
                keysBlocked = true;
                
                Timer timer = new Timer(( 3000 ),  new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        goToPanel(new GamePanel(new Dimension(500, 600)));
                    }
                });

                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    public static void GameOver(){
        goToPanel(new GameOverPanel(new Dimension(500, 600)));
    }
}
    
    

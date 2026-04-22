/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thirdpouject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author kkvu5
 */
public class Game extends JPanel implements KeyListener, ActionListener {
    private Cabbit cabbit;
    
    private static final int PANEL_WIDTH = 480;
    private static final int PANEL_HEIGHT = 360;

    public Game() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);   // required to receive KeyEvents
        addKeyListener(this);
        
    }
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    
    @Override public void actionPerformed(ActionEvent e) {
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thirdpouject;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author kkvu5
 */
class App {
    // other init game logic goes here
        private static void initCabbitGame() {
        JFrame window = new JFrame("The Cabbit Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);
 
        Game game = new Game();
        window.add(game, BorderLayout.CENTER);
        window.addKeyListener(game);
 
        // Button bar — each button's action command maps to Game.handleAction()
        JPanel buttons = new JPanel();
        for (String action : new String[]{"feed", "play", "shower", "potion"}) {
            JButton btn = new JButton(action);
            btn.setActionCommand(action);
            btn.addActionListener(game);
            buttons.add(btn);
        }
        window.add(buttons, BorderLayout.SOUTH);
 
        window.pack();
        window.setLocationRelativeTo(null);  // center on screen
        window.setVisible(true);
 
        // Give focus to the game panel so KeyListener works immediately
        game.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initCabbitGame();
            }
        });
    }
}

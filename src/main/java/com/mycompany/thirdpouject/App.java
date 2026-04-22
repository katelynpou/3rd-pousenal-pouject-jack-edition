/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thirdpouject;
import javax.swing.*;
/**
 *
 * @author kkvu5
 */
class App {
    // other init game logic goes here
    private static void initCabbitGame() {
        JFrame window = new JFrame("the cabbit game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game game = new Game();
        //window.add(game);
        //window.addKeyListener(game);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initCabbitGame();
            }
        });
    }
}

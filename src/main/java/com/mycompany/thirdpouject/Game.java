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
    private GamePhase phase;
    private int tickCount;
    private String lastMessage;
    
    private enum GamePhase {
        PLAYING,
        MINIGAME
    }
    
    private static final int PANEL_WIDTH = 480;
    private static final int PANEL_HEIGHT = 360;
    private static final int LOW_STAT_THRESHOLD = 20;

    public Game() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);   // required to receive KeyEvents
        addKeyListener(this);
        
        cabbit = new Cabbit("cabbit");
        phase = GamePhase.PLAYING;
        tickCount = 0;
        lastMessage = "Keys: [F]eed  [P]lay  [S]hower  [H]ealth potion";
    }
    
    @Override public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F -> handleAction("feed");
            case KeyEvent.VK_P -> handleAction("play");
            case KeyEvent.VK_S -> handleAction("shower");
            case KeyEvent.VK_H -> handleAction("potion");
        }

    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    
    @Override public void actionPerformed(ActionEvent e) {
        // feed, play buttons become 
        handleAction(e.getActionCommand());
    }
    
    public String handleAction(String action) {
        String act = action.toLowerCase();
        
        switch (act) {
            case "feed"   -> cabbit.feed();
            case "play"   -> cabbit.play();
            case "shower" -> cabbit.shower();
            case "potion" -> cabbit.potion();
        }
        
        repaint();
        return act;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        drawStats(g2);
    }

    
    private void drawStats(Graphics2D g) {
        g.setFont(new Font("Monospaced", Font.PLAIN, 14));
        int x = 20, y = 30, gap = 22;
 
        g.setColor(Color.BLACK);
        g.drawString(cabbit.getName(), x, y);
        y += gap;
 
        drawMoodBar(g, "Hunger  ", cabbit.getHunger(),  x, y); y += gap;
        drawMoodBar(g, "Mood    ", cabbit.getMood(),    x, y); y += gap;
        drawMoodBar(g, "Hygiene ", cabbit.getHygiene(), x, y); y += gap;
        drawMoodBar(g, "Health  ", cabbit.getHealth(),  x, y);
    }
    
    private void drawMoodBar(Graphics2D g, String label, int value, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawString(label, x, y);
 
        int barX = x + 90, barY = y - 12, barW = 200, barH = 14;
 
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(barX, barY, barW, barH);
 
        int fillW = (int)(barW * (value / 100.0));
        g.setColor(value < LOW_STAT_THRESHOLD ? Color.RED : new Color(60, 180, 80));
        g.fillRect(barX, barY, fillW, barH);
 
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(value), barX + barW + 8, y);
    }

}

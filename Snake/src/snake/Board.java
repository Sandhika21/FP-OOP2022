/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXPreloader.java to edit this template
 */
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Lenovo
 */
public class Board extends JPanel implements ActionListener, Storage {

    Integer[] x = new Integer[Storage.ALL_DOTS];
    Integer[] y = new Integer[Storage.ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        InItGame();
    }
    
    private void checkApple() {
        initGame IG = new initGame();
        if ((x[0] == IG.apple_x) && (y[0] == IG.apple_y)) { 
            IG.dots++;
            IG.locateApple();
        }
    }
    private void InItGame(){
        double z1;
        Data D;
        D = new initGame();
        D.dots = 3;
        for (int z = 0; z < D.dots; z++) {
            D.Add(x, (50 - z * 10), z);
            D = new CheckApple();
            z1 = z;
            D.Add(y, 50, z1);
        }
        D.locateApple();
        timer = new Timer(DELAY, this);
        timer.start();
    }
     private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}

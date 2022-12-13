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
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Board extends JPanel implements ActionListener, Storage {
    InputStream in;
    
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    ArrayList<String> command = new ArrayList<>();
   
    public int score = 0;
    public int count = 0;
    private int dots;
    private int apple_x;
    private int apple_y;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    
    public Board(){ /*constructor*/
        initBoard();
    }
    
    private void initBoard() {
        command.add("End"); /*arraylist*/
        command.add("Count");
        command.add("Snake");
        command.add("Point");
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        InItGame();
        
    }
    
     private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }
     
    private void checkApple() {
        LocateApple LA = new LocateApple();
        if ((LA.Get(x, 0) == getApple_x()) && (LA.Get(x, 0) == getApple_y())) { 
            count++;
            score += score + 1;
            setDots(locate() + 1);
            setApple_x(LA.locate());
            setApple_y(LA.locate());
        }
    }
    private void InItGame(){
        LocateApple LA = new LocateApple();
        setDots(3);
        for (int z = 0; z < locate(); z++) {
            LA.Set(x, z, 50 - z * 10);
            LA.Set(y, z, 50);
        }
        setApple_x(LA.locate());
        setApple_y(LA.locate());
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {        
        if (isInGame()) {            
            LocateApple LA = new LocateApple();  /*inheritance*/              

            g.drawImage(apple, getApple_x(), getApple_y(), this); /*GUI*/

            for (int z = 0; z < locate(); z++) {
                if (z == 0) {
                    g.drawImage(head, LA.Get(x, z), LA.Get(y, z), this);
                } else {
                    g.drawImage(ball, LA.Get(x, z), LA.Get(y, z), this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        }      
        else{
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        Collection<String> C = new Collection<>(); /*collection*/
        C.Add("End", "Game Over");
        C.Add("Count", "Apple : ");
        C.Add("Snake", "Length : ");
        C.Add("Point", "Score : ");
        
        String msg;
        String msg1;
        
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        
        msg = command.get(0);
        msg = C.GetK(msg);       
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
        msg = command.get(1);
        msg = C.GetK(msg); 
        msg1 = Integer.toString(count);
        g.drawString(msg+msg1, ((B_WIDTH - metr.stringWidth(msg)) / 2), (B_HEIGHT / 2) + 10);
        
        msg = command.get(2);
        msg = C.GetK(msg); 
        msg1 = Integer.toString(count+1);
        g.drawString(msg+msg1, ((B_WIDTH - metr.stringWidth(msg)) / 2), (B_HEIGHT / 2) + 20);
        
        msg = command.get(3);
        msg = C.GetK(msg); 
        msg1 = Integer.toString(score);
        g.drawString(msg+msg1, ((B_WIDTH - metr.stringWidth(msg)) / 2), (B_HEIGHT / 2) + 30);
    }
    
    private void move() {
        LocateApple LA = new LocateApple();
        LocateApple IG = new initGame(); /*polymorphism*/
        for (int z = locate(); z > 0; z--) {            
            LA.Set(x, z, LA.Set(x, z-1)); /*overloading*/
            LA.Set(y, z, LA.Set(y, z-1));
        }

        if (isLeftDirection()) {
            IG.Set(x, 0, 0-DOT_SIZE); /*overriding*/
        }

        if (isRightDirection()) {
            IG.Set(x, 0, DOT_SIZE);
        }

        if (isUpDirection()) {
            IG.Set(y, 0, 0-DOT_SIZE );
        }

        if (isDownDirection()) {
            IG.Set(y, 0, DOT_SIZE);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (isInGame()) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    
    private void checkCollision() {
         LocateApple LA = new LocateApple();

        for (int z = locate(); z > 0; z--) {

            if ((z > 4) && (LA.Set(x, 0) == LA.Set(x, z)) && (LA.Set(y, 0) == LA.Set(y, z))) {
                
                try{ /*exception handling*/
                    in = new FileInputStream(new File("src/resources/audio_up.wav")); /*input output*/
                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);
                }
                catch(IOException e){
                    
                }
            }
        }

        if (LA.Set(y, 0) >= B_HEIGHT) {
            setInGame(false);
                try{
                    in = new FileInputStream(new File("src/resources/audio_up.wav"));
                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);
                }
                catch(IOException e){
                    
                }
        }

        if (LA.Set(y, 0) < 0) {
            setInGame(false);
                try{
                    in = new FileInputStream(new File("src/resources/audio_up.wav"));
                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);
                }
                catch(IOException e){
                    
                }
        }

        if (LA.Set(x, 0) >= B_WIDTH) {            
            setInGame(false);
                try{
                    in = new FileInputStream(new File("src/resources/audio_up.wav"));
                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);
                }
                catch(IOException e){
                    
                }
        }

        if (LA.Set(x, 0) < 0) {
            setInGame(false);
                try{
                    in = new FileInputStream(new File("src/resources/audio_up.wav"));
                    AudioStream audios = new AudioStream(in);
                    AudioPlayer.player.start(audios);
                }
                catch(IOException e){
                    
                }
        }
        
        if (!isInGame()) {
            timer.stop();
        }
    }    

    @Override
    public int locate() {
        return dots;
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!isRightDirection())) {
                setLeftDirection(true);
                setUpDirection(false);
                setDownDirection(false);
            }

            if ((key == KeyEvent.VK_RIGHT) && (!isLeftDirection())) {
                setRightDirection(true);
                setUpDirection(false);
                setDownDirection(false);
            }

            if ((key == KeyEvent.VK_UP) && (!isDownDirection())) {
                setUpDirection(true);
                setRightDirection(false);
                setLeftDirection(false);
            }

            if ((key == KeyEvent.VK_DOWN) && (!isUpDirection())) {
                setDownDirection(true);
                setRightDirection(false);
                setLeftDirection(false);
            }
        }
    }

    public void setDots(int dots) {
        this.dots = dots;
    }

    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) { /*encapsulation*/
        this.apple_y = apple_y;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }

    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}

package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
    private final int ALL_DOTS = 2500;
    private final int DOT_SIZE = 10 ;
    private final int RANDOM_POSITION = 49;
    private boolean leftdirection = false;
    private boolean rightdirection = true;
    private boolean updirection = false;
    private boolean downdirection = false;
    private int apple_x ;
    private int apple_y ;
    private int dots;
    private Image apple;
    private Image dot;
    private Image head;
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private Timer timer ;
    private boolean inGame = true;
    Board() {
        addKeyListener(new Tadapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500,500));
        setFocusable(true);
        loadImages();
        initGame();
    }
    public void loadImages() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snake_game/icons/apple.png"));
        apple = i1.getImage();
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snake_game/icons/dot.png"));
        dot = i2.getImage();
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snake_game/icons/head.png"));
        head = i3.getImage();
    }
    public  void initGame() {
        dots = 3;
        for (int i = 0;i<dots;i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }
        locatApple();
        timer = new Timer(140,this);
        timer.start();
    }
    public void locatApple() {
        int r = (int)(Math.random() * RANDOM_POSITION);
        apple_x = r * DOT_SIZE;
        r = (int)(Math.random() * RANDOM_POSITION);
        apple_y = r * DOT_SIZE;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        if (inGame){
            g.drawImage(apple, apple_x, apple_y, this);
            for (int i=0;i<dots;i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                }
                else {
                    g.drawImage(dot, x[i], y[i], this);
                }
            }
        }
        else {
            gameOver(g);
        }
    }
    public void gameOver(Graphics g){
        String msg = "Game Over!";
        Font font = new Font("SAN_SERIF",Font.BOLD,14);
        FontMetrics metrices = getFontMetrics(font);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (500 - metrices.stringWidth(msg))/2, 500/2);
    }
    public void move() {
        for (int i=dots;i>0;i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (leftdirection) {
            x[0] -= DOT_SIZE;
        }
        if (rightdirection) {
            x[0] += DOT_SIZE;
        }
        if (updirection) {
            y[0] -= DOT_SIZE;
        }
        if (downdirection) {
            y[0] += DOT_SIZE;
        }
    }
    public void checkApple() {
        if ((x[0]==apple_x) && (y[0]==apple_y)) {
            dots++;
            locatApple();
        }
    }
    public void checkCollison() {
        for (int i=dots;i>0;i--){
            if ((i>4)&&(x[0] == x[i])&&(y[0] == y[i])){
                inGame = false;
            }
        }
        if (x[0] >= 500){
            inGame = false;
        }
        if (y[0] >= 500){
            inGame = false;
        }
        if (x[0] < 0){
            inGame = false;
        }
        if (y[0] < 0){
            inGame = false;
        }
        if (!inGame){
            timer.stop();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if (inGame){
            checkApple();
            checkCollison();
            move();
            repaint();
        }  
    }
    public class Tadapter extends KeyAdapter {
        @Override 
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && (!rightdirection)) {
                leftdirection = true;
                updirection = false;
                downdirection = false;
            }
            if (key == KeyEvent.VK_RIGHT && (!leftdirection)) {
                rightdirection = true;
                updirection = false;
                downdirection = false;
            }
            if (key == KeyEvent.VK_UP && (!downdirection)) {
                updirection = true;
                leftdirection = false;
                rightdirection = false;
            }
            if (key == KeyEvent.VK_DOWN && (!updirection)) {
                downdirection = true;
                leftdirection = false;
                rightdirection = false;
            }
            if ((key == KeyEvent.VK_SPACE) && (!inGame)){
                inGame = true;
                rightdirection = true;
                leftdirection = false;
                updirection = false;
                downdirection = false;
                initGame();
            }
        }
    }
}

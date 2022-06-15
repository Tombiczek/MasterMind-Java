package com.mastermind;

import com.gui.GameScreen;
import com.gui.MainMenuPanel;
import com.gui.PlayPanel;
import com.gui.PlayPanelEz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener, Runnable {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 950;
    public static final Font main = new Font("Arial", Font.PLAIN, 28);
    private boolean running;

    // zmienione na public, ale nie ma różnicy za bardzo
    public final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public final GameScreen screen;


    private long startTime;
    private long elapsed;
    private boolean set;

    public Game(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        screen = GameScreen.getInstance();
        screen.add("Menu", new MainMenuPanel());
        screen.add("Play", new PlayPanel());
        screen.add("EasterEgg", new Instruction());
        screen.add("PlayEasy", new PlayPanelEz());
        screen.setCurrentPanel("Menu");
    }

    private void update(){
        screen.update();
        Keyboard.update();
    }


    private void render(){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        screen.render(g);
        g.dispose();
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
    }


    // Tylko na potrzeby testów
    public void renderScore(int cow, int counterRow){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.cyan);
        g.setFont(main);
        g.drawString("5"+ cow, 20, 20 + (counterRow * 60));
    }



    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        Keyboard.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keyboard.keyReleased(e);
    }


    @Override
    public void run() {
        int fps = 0, updates = 0;
        long fpsTimer = System.currentTimeMillis();
        boolean shouldRender = false;
        double nsPerUpdate = 1000000000.0 / 60;

        double then = System.nanoTime();
        // how many updates do we have to do in case rendering falls behind
        double unprocessed = 0;

        while(running) {

            double now = System.nanoTime();
            unprocessed += (now - then) / nsPerUpdate;
            then = now;


            // update queue
            while (unprocessed >= 1) {
                updates++;
                update();
                unprocessed--;
                shouldRender = true;
            }

            // render
            if (shouldRender) {
                fps++;
                render();
                shouldRender = false;
            } else {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // fps timer
            if (System.currentTimeMillis() - fpsTimer > 1000) {
                System.out.printf("%d fps", fps);
                System.out.println();
                fps = 0;
                updates = 0;
                fpsTimer += 1000;
            }
        }
    }

    public synchronized void start(){
        if(running)return;
        running = true;
        Thread game = new Thread(this, "game");
        game.start();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        screen.mousePressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        screen.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        screen.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        screen.mouseMoved(e);
    }
}

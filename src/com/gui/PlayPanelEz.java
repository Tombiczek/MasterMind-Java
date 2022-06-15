package com.gui;

import com.mastermind.GameBoardEz;
import com.mastermind.DrawUtils;
import com.mastermind.Game;
import com.mastermind.GameBoard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayPanelEz extends GamePanel{
    private final GameBoardEz board;
    private final BufferedImage info;
    private final Font scoreFont;


    private final GuiButton mainMenu;

    private final GuiButton quit;
    private final GuiButton mainMenu2;

    private boolean added;
    private int alpha;
    private final Font gameOverFont;

    public PlayPanelEz(){
        scoreFont = Game.main.deriveFont(24f);
        gameOverFont = Game.main.deriveFont(70f);
        board = new GameBoardEz(Game.WIDTH / 2 - GameBoard.BOARD_WIDTH / 2, Game.HEIGHT - GameBoard.BOARD_HEIGHT - 20);
        info = new BufferedImage(Game.WIDTH, 200, BufferedImage.TYPE_INT_RGB);

        int buttonWidth = 160;
        int buttonHeight = 50;
        mainMenu = new GuiButton(Game.WIDTH / 2 - 80, 400, buttonWidth, buttonHeight);
        quit = new GuiButton(Game.WIDTH / 2 - 80, 480, buttonWidth, buttonHeight);
        mainMenu2 = new GuiButton(Game.WIDTH / 2 + 120, 20, 100, 30);

        mainMenu.setText("Main Menu");
        quit.setText("Quit");
        mainMenu2.setText("menu");

        mainMenu.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("Menu"));

        quit.addActionListener(e -> System.exit(0));

        mainMenu2.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("Menu"));
    }


    private void drawGui(Graphics2D g){
        Graphics2D g2d = (Graphics2D) info.getGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, info.getWidth(), info.getHeight());
        g2d.setColor(Color.red);
        g2d.setFont(scoreFont);
        g2d.setColor(Color.black);
        g2d.drawString("Time: " + DrawUtils.formattedTime, 30, 40);
        g2d.dispose();
        g.drawImage(info, 0, 0, null);
    }

    public void drawGameOver(Graphics2D g){
        g.setColor(new Color(222, 222, 222, alpha));
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.red);
        g.setFont(gameOverFont);
        g.drawString("Game Over!!!",
                Game.WIDTH /2 - 200, 250);
    }

    public void drawGameWon(Graphics2D g){
        g.setColor(new Color(222, 222, 222, alpha));
        g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.green);
        g.setFont(gameOverFont);
        g.drawString("You Won!!!",
                Game.WIDTH /2 - 200, 250);
    }

    @Override
    public void update(){
        board.update();
        if(board.isLost()){
            alpha++;
            if(alpha > 170) alpha = 170;
        }
    }


    @Override
    public void render(Graphics2D g){
        drawGui(g);
        board.render(g);
        add(mainMenu2);
        if (board.isLost()) {
            board.counterRow = 11;
            board.code.clear();
            if(!added){
                added = true;
                add(mainMenu);
                add(quit);
            }
            drawGameOver(g);
        }
        if(board.isWon()){
            board.counterRow = 11;
            board.code.clear();
            if(!added) {
                added = true;
                add(mainMenu);
                add(quit);
            }
            drawGameWon(g);
        }
        super.render(g);
    }
}

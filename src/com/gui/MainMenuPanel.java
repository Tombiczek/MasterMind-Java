package com.gui;

import com.mastermind.DrawUtils;
import com.mastermind.Game;
import com.mastermind.ResetGame;

import java.awt.*;

public class MainMenuPanel extends GamePanel{

    private final Font titleFont = Game.main.deriveFont(60f);


    public MainMenuPanel(){
        super();
        int buttonHeight = 60;
        int buttonWidth = 200;
        int spacing = 120;
        GuiButton playButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, 260, buttonWidth, buttonHeight);

        GuiButton playButtonEasy = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, playButton.getY() + spacing,
                buttonWidth, buttonHeight);
        GuiButton scoresButton = new GuiButton(Game.WIDTH / 2 - buttonWidth / 2, playButtonEasy.getY() + spacing,
                buttonWidth, buttonHeight);
        GuiButton quitButton = new GuiButton(Game.WIDTH / 2 + 20, 850,
                buttonWidth, buttonHeight);
        GuiButton resetButton = new GuiButton(Game.WIDTH / 2 - (buttonWidth + 20), 850, buttonWidth,
                buttonHeight);

        playButton.setText("Play");
        playButtonEasy.setText("Play Easy");
        scoresButton.setText("Instructions");
        quitButton.setText("Quit");
        resetButton.setText("Reset");

        playButton.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("Play"));

        scoresButton.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("EasterEgg"));

        playButtonEasy.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("PlayEasy"));

        quitButton.addActionListener(e -> System.exit(0));

        resetButton.addActionListener(e -> {
            ResetGame resetGame = new ResetGame();
        });



        add(playButton);
        add(playButtonEasy);
        add(scoresButton);
        add(quitButton);
        add(resetButton);
    }

    @Override
    public void render(Graphics2D g){
        super.render(g);
        g.setFont(titleFont);
        g.setColor(Color.black);
        String title = "MasterMind";
        g.drawString(title, Game.WIDTH / 2 - DrawUtils.getMessageWidth(title, titleFont, g) / 2, 150);
    }
}

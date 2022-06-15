package com.mastermind;

import javax.swing.*;

public class Start {

    public static void main(String[] args){
        Game game = new Game();
        JFrame window = new JFrame("MasterMind");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        game.start();
    }
}

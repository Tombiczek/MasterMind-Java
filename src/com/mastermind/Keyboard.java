package com.mastermind;

import java.awt.event.KeyEvent;

public class Keyboard {

    public static final boolean[] pressed = new boolean[256];
    public static final boolean[] prev = new boolean[256];


    private Keyboard(){}

    public static void update(){
        for(int i = 0; i < 9; i++){
            if(i == 0) prev[KeyEvent.VK_Q] = pressed[KeyEvent.VK_Q];
            if(i == 1) prev[KeyEvent.VK_W] = pressed[KeyEvent.VK_W];
            if(i == 2) prev[KeyEvent.VK_E] = pressed[KeyEvent.VK_E];
            if(i == 3) prev[KeyEvent.VK_R] = pressed[KeyEvent.VK_R];
            if(i == 4) prev[KeyEvent.VK_A] = pressed[KeyEvent.VK_A];
            if(i == 5) prev[KeyEvent.VK_S] = pressed[KeyEvent.VK_S];
            if(i == 6) prev[KeyEvent.VK_D] = pressed[KeyEvent.VK_D];
            if(i == 7) prev[KeyEvent.VK_F] = pressed[KeyEvent.VK_F];
            if(i == 8) prev[KeyEvent.VK_SPACE] = pressed[KeyEvent.VK_SPACE];
        }
    }

    public static void keyPressed(KeyEvent e){
        pressed[e.getKeyCode()] = true;
    }

    public static void keyReleased(KeyEvent e){
        pressed[e.getKeyCode()] = false;
    }

    public static boolean typed(int keyEvent){
        return !pressed[keyEvent] && prev[keyEvent];
    }
}

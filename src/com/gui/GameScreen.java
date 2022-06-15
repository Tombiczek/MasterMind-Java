package com.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class GameScreen {

    private static GameScreen screen;
    private final HashMap<String, GamePanel> panels;
    private String currentPanel = "";


    private GameScreen(){
        panels = new HashMap<>();
    }

    public static GameScreen getInstance(){
        if(screen == null){
            screen = new GameScreen();
        }
        return screen;
    }

    public void update(){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).update();
        }
    }

    public void render(Graphics2D g){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).render(g);
        }
    }

    public void add(String panelName, GamePanel panel){
        panels.put(panelName, panel);
    }

    public void setCurrentPanel(String panelName){
        currentPanel = panelName;
    }

    public void mousePressed(MouseEvent e){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e){
        if(panels.get(currentPanel) != null){
            panels.get(currentPanel).mouseMoved(e);
        }
    }
}

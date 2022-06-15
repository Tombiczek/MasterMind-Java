package com.gui;

import com.mastermind.DrawUtils;
import com.mastermind.Game;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GuiButton {

    private State currentState = State.RELEASED;
    private final Rectangle clickBox;
    private final ArrayList<ActionListener> actionListeners;
    private String text = "";
    private final Color released;
    private final Color hover;
    private final Color pressed;
    private final Font font = Game.main.deriveFont(22f);

    public GuiButton(int x, int y, int width,int height){
        clickBox = new Rectangle(x, y, width, height);
        actionListeners = new ArrayList<>();
        released = new Color(173, 177, 179);
        hover = new Color(150, 156, 158);
        pressed = new Color(110, 116, 117);
    }

    public void update(){}

    public void render(Graphics2D g){
        if(currentState == State.RELEASED){
            g.setColor(released);
            g.fill(clickBox);
        }else if(currentState == State.HOVER){
            g.setColor(hover);
            g.fill(clickBox);
        }else{
            g.setColor(pressed);
            g.fill(clickBox);
        }
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(text, clickBox.x + clickBox.width / 2 - DrawUtils.getMessageWidth(text, font, g) / 2,
                clickBox.y + clickBox.height / 2 + DrawUtils.getMessageHeight(text, font, g) / 2);
    }


    public void addActionListener(ActionListener listener){
        actionListeners.add(listener);
    }

    public void mousePressed(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            currentState = State.PRESSED;
        }
    }

    public void mouseReleased(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            for(ActionListener al : actionListeners){
                al.actionPerformed(null);
            }
        }
        currentState = State.RELEASED;
    }

    public void mouseDragged(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.PRESSED;
        } else {
            currentState = State.RELEASED;
        }
    }

    public void mouseMoved(MouseEvent e){
        if (clickBox.contains(e.getPoint())) {
            currentState = State.HOVER;
        } else {
            currentState = State.RELEASED;
        }
    }

    public int getY(){
        return clickBox.y;
    }


    public void setText(String text){
        this.text = text;
    }

    private enum State{
        RELEASED,
        HOVER,
        PRESSED
    }
}

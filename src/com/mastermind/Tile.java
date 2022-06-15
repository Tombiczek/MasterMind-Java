package com.mastermind;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    public static final int ARC_WIDTH = 10;
    public static final int ARC_HEIGHT = 10;

    public final int value;
    private final BufferedImage tileImage;
    private final int x;
    private final int y;

    public Tile(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
        tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawImage();
    }

    private void drawImage() {
        Graphics2D g = (Graphics2D) tileImage.getGraphics();
        Color text;
        Color background;
        if (value == 1) {
            background = new Color(0xFFFFFF);
            text = new Color(0x000000);
        } else if (value == 2) {
            background = new Color(0xF040D5);
            text = new Color(0x000000);
        } else if (value == 3) {
            background = new Color(0x42EB3F);
            text = new Color(0x000000);
        } else if (value == 4) {
            background = new Color(0xEB3F42);
            text = new Color(0x000000);
        } else if (value == 5) {
            background = new Color(0xEB953F);
            text = new Color(0x000000);
        } else if (value == 6) {
            background = new Color(0x5F5F5E);
            text = new Color(0x000000);
        } else if (value == 7) {
            background = new Color(0xDDEF2D);
            text = new Color(0x000000);
        } else if (value == 8) {
            background = new Color(0x2473D3);
            text = new Color(0x000000);
        }else{
            background = Color.black;
            text = Color.white;
        }

        g.setColor(new Color(0, 0 , 0, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(background);
        g.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);

        g.setColor(text);

        Font font = Game.main;
        g.setFont(font);

        int drawX = WIDTH / 2 - DrawUtils.getMessageWidth(""+ value, font, g)/2;
        int drawY = HEIGHT / 2 + DrawUtils.getMessageHeight("" + value, font, g)/2;
//        tutaj jak dodamy "" + value to się będą pokazywały numerki, ale mama mówi, że lepiej bez
//        g.drawString("" + value, drawX, drawY);
        g.drawString("", drawX, drawY);
        g.dispose();
    }

    public void render(Graphics2D g){
        g.drawImage(tileImage, x, y, null);
    }
}

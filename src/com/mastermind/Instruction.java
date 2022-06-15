package com.mastermind;

import com.gui.GamePanel;
import com.gui.GameScreen;
import com.gui.GuiButton;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.mastermind.Game.HEIGHT;
import static com.mastermind.Game.WIDTH;

public class Instruction extends GamePanel {


    private final BufferedImage instruction;
    private final GuiButton quit;
    private final Font bigFont = Game.main.deriveFont(40f);
    private final Font font = Game.main.deriveFont(18f);



    public Instruction() {
        instruction = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        quit = new GuiButton(WIDTH / 2 - 80, 770, 160, 50);
        quit.setText("Back");

        quit.addActionListener(e -> GameScreen.getInstance().setCurrentPanel("Menu"));
    }

    public void drawText(Graphics2D g){
        Graphics2D g2d = (Graphics2D) instruction.getGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, instruction.getWidth(), instruction.getHeight());
        g2d.setColor(Color.black);
        String title = "Instrukcja";
        g2d.drawString(title, (instruction.getWidth() / 2 - DrawUtils.getMessageWidth(title, bigFont, g2d) / 2), 80);
        g2d.setFont(font);
        g2d.drawString("Odgadnij ukryty kod!", 165, 150);
        g2d.drawString("Mastermind to logiczna gra planszowa wynaleziona", 30, 200);
        g2d.drawString("wynaleziona w 1970 roku przez Mordechaja", 30, 230);
        g2d.drawString("Meirowitza, izraelskiego naczelnika poczty i", 30, 260);
        g2d.drawString("eksperta w dziedzinie telekomunikacji.", 30, 290);
        g2d.drawString("Twoim zadaniem jest odnaleźć ukryty kod", 30, 340);
        g2d.drawString("składający się z czterech kolorów. Kolory możesz", 30, 370);
        g2d.drawString("wybrać za pomocą klawiszy Q W E R (a także A S", 30, 400);
        g2d.drawString("D F), wybraną kombinację zatwierdź klawiszem", 30, 430);
        g2d.drawString("SPACJA. Po lewej stronie wyświetla się liczba", 30, 460);
        g2d.drawString("kolorów znajdujących się na właściwej pozycji,", 30, 490);

        g2d.drawString("po prawej zaś, liczba dobrze wybranych kolorów", 30, 520);
        g2d.drawString("znajdujących się na niewłaściwej pozycji. Masz", 30, 550);
        g2d.drawString("12 prób, z każdą kolejną jesteś coraz bliżej", 30, 580);
        g2d.drawString("odkrycia właściwej kombinacji!", 30, 610);
        g2d.drawString("Masz problemy z odgadnięciem kodu?", 30, 660);
        g2d.drawString("Wypróbuj tryb 'Easy', w którym kolory losowanej", 30, 690);
        g2d.drawString("kombinacji nie mogą się powtarzać.", 30, 720);
        g2d.dispose();
        g.drawImage(instruction, 0, 0, null);
    }

    @Override
    public void render(Graphics2D g){
        drawText(g);
        add(quit);
        super.render(g);
    }
}

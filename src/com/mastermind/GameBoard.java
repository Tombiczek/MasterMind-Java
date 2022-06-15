package com.mastermind;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.mastermind.Game.*;

public class GameBoard {

    public static final int ROWS = 12;
    public static final int COLUMNS = 4;

    private Tile[][] board;
    private boolean lost;
    private boolean won;
    private final BufferedImage gameBoard;
    private final BufferedImage finalBoard;

    private final int x;
    private final int y;

    private static final int SPACING = 10;
    public static final int BOARD_WIDTH = (COLUMNS + 1) * SPACING + COLUMNS * Tile.WIDTH;
    public static final int BOARD_HEIGHT= (ROWS + 1) * SPACING + ROWS * Tile.HEIGHT;


    private long elapsedS;
    private long startTime;
    private boolean hasStarted;



    public final List<String> givenOptions = Arrays.asList("1", "2", "3", "4", "5", "6", "7" ,"8");
    public final List<Integer> code = new ArrayList<>();
    public final List<Integer> choice = new ArrayList<>();

    final Object[] objCode = {code};
    final Object[] objChoice = {choice};

    public int cow = 0;
    public int bull = 0;


    public int counterRow = 11;
    private int counterQ = 1;
    private int counterW = 1;
    private int counterE = 1;
    private int counterR = 1;



    public GameBoard(int x, int y){
        this.x = x;
        this.y = y;
        board = new Tile[ROWS][COLUMNS];
        gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        finalBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedImage info = new BufferedImage(Game.WIDTH, 200, BufferedImage.TYPE_INT_RGB);
        startTime = System.nanoTime();
        createBoardImage();
        start();
    }

    public void reset(){
        Game game = new Game();
        board = new Tile[ROWS][COLUMNS];
        start();
        DrawUtils.formattedTime = null;
        hasStarted = false;
        startTime = System.nanoTime();
        cow = 0;
        bull = 0;
        counterRow = 11;
        elapsedS = 0;
    }



    public void createBoardImage(){
        Graphics2D g = (Graphics2D) gameBoard.getGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g.setColor(Color.lightGray);

        for(int row = 0; row < ROWS; row++){
            for(int columns = 0; columns < COLUMNS; columns++){
                int x = SPACING + SPACING * columns + Tile.WIDTH * columns;
                int y = SPACING + SPACING * row + Tile.HEIGHT * row;
                g.fillRoundRect(x, y, Tile.WIDTH, Tile.HEIGHT, Tile.ARC_WIDTH, Tile.ARC_HEIGHT);
            }
        }
    }

    private void start(){
        getCombination(givenOptions);
    }

    public void getCombination(List<String> arr){
        Random rand = new Random();
        final int numOfElements = 4;
        int chosenElement;

        for (int i = 0; i < numOfElements; i++) {
            int randomIndex = rand.nextInt(arr.size());
            String randomElement = arr.get(randomIndex);
            chosenElement = Integer.parseInt(randomElement);
            code.add(chosenElement);
        }
    }

    private void checkIfWon(ArrayList<Integer> choice){
        cow = 0;
        bull = 0;
        for (int i = 0; i < 4; i++) {
            if(code.get(i).equals(choice.get(i))){
                cow++;
            }else if (code.contains(choice.get(i))){
                bull++;
            }
        }
    }

    public void checkIfGameWon(){
        if(Arrays.equals(objCode, objChoice)){
            won = true;
        }
    }

    public boolean isWon(){
        return won;
    }

    public boolean isLost(){
        return lost;
    }



    public int getTileX(int column){
        return SPACING + column * Tile.WIDTH + column * SPACING;
    }

    public int getTileY(int row){
        return SPACING + row * Tile.HEIGHT + row * SPACING;
    }




    public void render(Graphics2D g){
        Graphics2D g2d = (Graphics2D) finalBoard.getGraphics();
        g2d.drawImage(gameBoard, 0, 0, null);
        for(int row = 0; row < ROWS; row++){
            for(int column = 0; column < COLUMNS; column++){
                Tile current = board[row][column];
                if(current == null) continue;
                current.render(g2d);
            }
        }

        g.drawImage(finalBoard, x, y, null);
        g2d.dispose();

        g.setColor(Color.darkGray);
        g.setFont(main);
        g.drawString(""+ cow, 60, 910);
        g.setColor(Color.red);
        g.drawString(""+ bull, 420, 910);

//        Uncomment if you want to see the combination
//        g.setColor(Color.cyan);
//        g.drawString(""+code, Game.WIDTH / 2 - 65, 30);
    }

    public void drawTile(int row, int column, int value){
        Tile tile = new Tile(value, getTileX(column), getTileY(row));
        board[row][column] = tile;
    }


    public void update(){
        if(!isLost() && !isWon()) {
            if (hasStarted) {
                elapsedS = (System.nanoTime() - startTime) / 1000000;
                DrawUtils.formattedTime = DrawUtils.formatTime(elapsedS);
            } else {
                startTime = System.nanoTime();
            }
        }
        checkKeys();
    }

    private void checkKeys() {
        if(Keyboard.typed(KeyEvent.VK_Q)) {
            if (!hasStarted) hasStarted = true;
            if (board[counterRow][0] == null) {
                counterQ = 1;
                drawTile(counterRow, 0, 1);
            } else {
                if (counterQ < 8) {
                    counterQ++;
                } else {
                    counterQ = 1;
                }
                drawTile(counterRow, 0, counterQ);
            }
        }
        if(Keyboard.typed(KeyEvent.VK_W)){
            if (!hasStarted) hasStarted = true;
            if (board[counterRow][1] == null) {
                counterW = 1;
                drawTile(counterRow, 1, counterW);
            } else {
                if (counterW < 8) {
                    counterW++;
                } else {
                    counterW = 1;
                }
                drawTile(counterRow, 1, counterW);
            }
        }
        if(Keyboard.typed(KeyEvent.VK_E)){
            if (!hasStarted) hasStarted = true;
            if (board[counterRow][2] == null) {
                counterE = 1;
                drawTile(counterRow, 2, 1);
            } else {
                if (counterE < 8) {
                    counterE++;
                } else {
                    counterE = 1;
                }
                drawTile(counterRow, 2, counterE);
            }
        }
        if(Keyboard.typed(KeyEvent.VK_R)){
            if(!hasStarted) hasStarted = true;
            if(board[counterRow][3] == null) {
                counterR = 1;
                drawTile(counterRow, 3, 1);
            }else {
                if (counterR < 8) {
                    counterR++;
                } else {
                    counterR = 1;
                }
                drawTile(counterRow, 3, counterR);
            }
        }
        if(Keyboard.typed(KeyEvent.VK_A)){
            if(board[counterRow][0] == null){
                counterQ = 8;
                drawTile(counterRow, 0, 8);
            }else if(counterQ != 1){
                counterQ --;
                drawTile(counterRow, 0, counterQ);
            } else {
                counterQ = 8;
                drawTile(counterRow, 0, counterQ);
            }
        }

        if(Keyboard.typed(KeyEvent.VK_S)) {
            if(board[counterRow][1] == null){
                counterW = 8;
                drawTile(counterRow, 1, 8);
            }else if(counterW != 1){
                counterW --;
                drawTile(counterRow, 1, counterW);
            } else {
                counterW = 8;
                drawTile(counterRow, 1, counterW);
            }
        }

        if(Keyboard.typed(KeyEvent.VK_D)) {
            if(board[counterRow][2] == null){
                counterE = 8;
                drawTile(counterRow, 2, 8);
            }else if(counterE != 1){
                counterE --;
                drawTile(counterRow, 2, counterE);
            } else {
                counterE = 8;
                drawTile(counterRow, 2, counterE);
            }
        }

        if(Keyboard.typed(KeyEvent.VK_F)) {
            if(board[counterRow][3] == null){
                counterR = 8;
                drawTile(counterRow, 3, 8);
            }else if(counterR != 1){
                counterR --;
                drawTile(counterRow, 3, counterR);
            } else {
                counterR = 8;
                drawTile(counterRow, 3, counterR);
            }
        }

        if(Keyboard.typed(KeyEvent.VK_SPACE)){
            Tile currentQ = board[counterRow][0];
            Tile currentW = board[counterRow][1];
            Tile currentE = board[counterRow][2];
            Tile currentR = board[counterRow][3];
            if(currentQ != null && currentW != null && currentE != null && currentR != null) {
                if (counterRow > 0) {
                    choice.add(counterQ);
                    choice.add(counterW);
                    choice.add(counterE);
                    choice.add(counterR);
                    checkIfGameWon();
                    checkIfWon((ArrayList<Integer>) choice);
                    counterRow--;
                    choice.clear();
                } else {
                    lost = true;
                }
            }
        }
    }
}

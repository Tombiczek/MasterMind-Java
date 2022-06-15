package com.mastermind;

import java.util.List;
import java.util.Random;



public class GameBoardEz extends GameBoard{

    public GameBoardEz(int x, int y) {
        super(x, y);
    }



    @Override
    public void getCombination(List<String> arr){
        Random rand = new Random();
        final int numOfElements = 4;
        int chosenElement;
        for (int i = 0; i < numOfElements; i++) {
            int randomIndex = rand.nextInt(arr.size());
            String randomElement = arr.get(randomIndex);
            chosenElement = Integer.parseInt(randomElement);
            if(code.contains(chosenElement)) {
                while (code.contains(chosenElement)) {
                    randomIndex = rand.nextInt(arr.size());
                    randomElement = arr.get(randomIndex);
                    chosenElement = Integer.parseInt(randomElement);
                }
            }
            code.add(chosenElement);
        }
    }
}

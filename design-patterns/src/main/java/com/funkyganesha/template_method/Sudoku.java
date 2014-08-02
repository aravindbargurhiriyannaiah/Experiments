package com.funkyganesha.template_method;

/**
 * Created by barga009 on 8/2/14 at 1:41 AM. Comment {"$EXPR$"}
 */
public class Sudoku extends Game {
    private int numberOfPlayers = 1;
    @Override
    public void initialize() {
        //Create a 9x9 square board with numbers filled in randomly based on difficulty
    }

    @Override
    public int decideNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public String decideWinner() {
        //If Sudoku has been solved properly, declare winner
        return null;
    }
}

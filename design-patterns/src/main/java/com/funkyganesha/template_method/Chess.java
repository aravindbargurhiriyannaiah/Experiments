package com.funkyganesha.template_method;

/**
 * Created by barga009 on 8/2/14 at 1:43 AM. Comment {"$EXPR$"}
 */
public class Chess extends Game {
    private int numberOfPlayers = 2;
    @Override
    public void initialize() {
        //Create a 8x8 square board, with alternate black and white boxes. Create all the pawns, etc.
    }

    @Override
    public int decideNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public String decideWinner() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

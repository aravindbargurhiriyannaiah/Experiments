package com.funkyganesha.template_method;

/**
 * Created by barga009 on 8/2/14 at 1:39 AM. Comment {"$EXPR$"}
 */
public abstract class Game {
    abstract void initialize();
    abstract int decideNumberOfPlayers();
    abstract String decideWinner();

    public void play(){
        initialize();
        decideNumberOfPlayers();
        decideWinner();
    }
}



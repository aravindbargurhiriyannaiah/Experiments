package com.funkyganesha.template_method;

/**
 * Created by barga009 on 8/2/14 at 1:39 AM. Comment {"$EXPR$"}
 */
public abstract class Game {
    //Abstract methods which are game specific
    abstract void initialize();
    abstract int decideNumberOfPlayers();
    abstract String decideWinner();

    public final void play(){
        initialize();
        decideNumberOfPlayers();
        decideWinner();
    }
}



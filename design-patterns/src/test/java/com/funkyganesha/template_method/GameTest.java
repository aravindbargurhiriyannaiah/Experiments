package com.funkyganesha.template_method;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by barga009 on 8/2/14 at 1:46 AM. Comment {"$EXPR$"}
 */
public class GameTest {
    @Test
    public void testPlaySudoku() {
        Game game = new Sudoku();
        game.play();
        assertEquals("Invalid number of players returned", 1, game.decideNumberOfPlayers());
    }

    @Test
    public void testPlayChess() {
        Game game = new Chess();
        game.play();
        assertEquals("Invalid number of players returned", 2, game.decideNumberOfPlayers());
    }
}

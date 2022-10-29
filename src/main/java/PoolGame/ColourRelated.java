package PoolGame;

import PoolGame.strategy.BallStrategy;
import PoolGame.strategy.BlueStrategy;
import PoolGame.strategy.BrownStrategy;
import PoolGame.strategy.PocketStrategy;
import javafx.scene.paint.Paint;

/**
 * Integration of colour related decisions
 * for extension, just modify this class
 */
public class ColourRelated {
    /**
     * return score when falling into pockets corresponding to colour
     *
     * @param colour of the ball
     * @return score corresponding to colour
     */
    public static int scoreColour(Paint colour) {
        if (colour.equals(Paint.valueOf("red"))) {
            return 1;
        } else if (colour.equals(Paint.valueOf("yellow"))) {
            return 2;
        } else if (colour.equals(Paint.valueOf("green"))) {
            return 3;
        } else if (colour.equals(Paint.valueOf("brown"))) {
            return 4;
        } else if (colour.equals(Paint.valueOf("blue"))) {
            return 5;
        } else if (colour.equals(Paint.valueOf("purple"))) {
            return 6;
        } else if (colour.equals(Paint.valueOf("black"))) {
            return 7;
        } else if (colour.equals(Paint.valueOf("orange"))) {
            return 8;
        }
        return 0;
    }

    /**
     * return strategy based on the colour of the ball
     * @param colour of the ball
     * @return strategy
     */
    public static PocketStrategy strategyColour(String colour) {
        PocketStrategy strategy = null;
        if (colour.equals("white")) {
            strategy = new BallStrategy();
        } else if (colour.equals("blue") || colour.equals("green") || colour.equals("purple")) {
            strategy = new BlueStrategy();
        } else if (colour.equals("red") || colour.equals("orange") || colour.equals("yellow")) {
            strategy = new BallStrategy();
        } else if (colour.equals("black") || colour.equals("brown")) {
            strategy = new BrownStrategy();
        }
        return strategy;
    }
}

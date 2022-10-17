package PoolGame.strategy;

/**
 * first 2 times: be back to its initial position
 * third time: disappear
 */
public class BrownStrategy extends PocketStrategy {
    public BrownStrategy() {
        this.lives = 3;
    }

    public void reset() {
        this.lives = 3;
    }
}

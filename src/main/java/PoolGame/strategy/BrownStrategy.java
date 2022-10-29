package PoolGame.strategy;

/**
 * first 2 times: be back to its initial position
 * third time: disappear
 */
public class BrownStrategy extends PocketStrategy {
    /**
     * constructor with 3 lives
     */
    public BrownStrategy() {
        this.lives = 3;
    }

    /** reset */
    public void reset() {
        this.lives = 3;
    }

    /**
     * deep copy
     * @return a deep copy of BrownStrategy
     */
    @Override
    public BrownStrategy copy() {
        BrownStrategy ballStrategy = new BrownStrategy();
        ballStrategy.setLives(lives);
        return ballStrategy;
    }
}

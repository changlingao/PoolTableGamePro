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
     * used with copy() for Prototype
     * @param brownStrategy to be cloned
     */
    private BrownStrategy(BrownStrategy brownStrategy) {
        this.lives = brownStrategy.getLives();
    }

    /**
     * Prototype design pattern
     * @return a deep copy of BallStrategy
     */
    @Override
    public BrownStrategy copy() {
        return new BrownStrategy(this);
    }
}

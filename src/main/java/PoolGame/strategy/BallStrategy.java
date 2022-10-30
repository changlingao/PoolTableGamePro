package PoolGame.strategy;

public class BallStrategy extends PocketStrategy {
    /**
     * Creates a new ball strategy.
     */
    public BallStrategy() {
        this.lives = 1;
    }

    /** reset */
    public void reset() {
        this.lives = 1;
    }

    /**
     * used with copy() for Prototype
     * @param ballStrategy to be cloned
     */
    private BallStrategy(BallStrategy ballStrategy) {
        this.lives = ballStrategy.getLives();
    }

    /**
     * Prototype design pattern
     * @return a deep copy of BallStrategy
     */
    @Override
    public BallStrategy copy() {
        return new BallStrategy(this);
    }
}

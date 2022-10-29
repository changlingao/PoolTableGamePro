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
     * deep copy
     * @return a deep copy of BallStrategy
     */
    @Override
    public BallStrategy copy() {
        BallStrategy ballStrategy = new BallStrategy();
        ballStrategy.setLives(lives);
        return ballStrategy;
    }
}

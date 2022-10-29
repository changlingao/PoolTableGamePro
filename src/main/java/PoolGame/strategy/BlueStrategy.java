package PoolGame.strategy;

/**
 * 2 lives
 */
public class BlueStrategy extends PocketStrategy {
    /** Creates a new blue strategy. */
    public BlueStrategy() {
        this.lives = 2;
    }

    /** reset */
    public void reset() {
        this.lives = 2;
    }

    /**
     * deep copy
     * @return a deep copy of BlueStrategy
     */
    @Override
    public BlueStrategy copy() {
        BlueStrategy ballStrategy = new BlueStrategy();
        ballStrategy.setLives(lives);
        return ballStrategy;
    }
}

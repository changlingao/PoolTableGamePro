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
     * used with copy() for Prototype
     * @param blueStrategy to be cloned
     */
    private BlueStrategy(BlueStrategy blueStrategy) {
        this.lives = blueStrategy.getLives();
    }

    /**
     * Prototype design pattern
     * @return a deep copy of BallStrategy
     */
    @Override
    public BlueStrategy copy() {
        return new BlueStrategy(this);
    }
}

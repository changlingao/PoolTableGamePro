package PoolGame.objects;

import PoolGame.config.Config;
import PoolGame.strategy.PocketStrategy;
import javafx.scene.paint.Paint;

/** Holds information for all ball-related objects. */
public class Ball {

    private Paint colour;
    private double xPosition;
    private double yPosition;
    private double startX;
    private double startY;
    private double xVelocity;
    private double yVelocity;
    private double mass;
    private double radius;
    private boolean isCue;
    private boolean isActive;
    private PocketStrategy strategy;

    private static final double MAXVEL = 20;

    /** Constructor */
    public Ball(String colour, double xPosition, double yPosition, double xVelocity, double yVelocity, double mass,
            boolean isCue, PocketStrategy strategy) {
        this.colour = Paint.valueOf(colour);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.startX = xPosition;
        this.startY = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.mass = mass;
        this.radius = 10;
        this.isCue = isCue;
        this.isActive = true;
        this.strategy = strategy;
    }

    /**
     * Updates ball position per tick.
     */
    public void tick() {
        xPosition += xVelocity;
        yPosition += yVelocity;
    }

    /**
     * Resets ball position, velocity, and activity.
     */
    public void reset() {
        resetPosition();
        isActive = true;
        strategy.reset();
    }

    /**
     * Resets ball position and velocity.
     */
    public void resetPosition() {
        xPosition = startX;
        yPosition = startY;
        xVelocity = 0;
        yVelocity = 0;
    }

    /**
     * Removes ball from play.
     * 
     * @return true if ball is successfully removed
     */
    public boolean remove() {
        if (strategy.remove()) {
            isActive = false;
            return true;
        } else {
            resetPosition();
            return false;
        }
    }

    /**
     * Sets x-axis velocity of ball.
     * 
     * @param xVelocity of ball.
     */
    public void setxVel(double xVelocity) {
        if (xVelocity > MAXVEL) {
            this.xVelocity = MAXVEL;
        } else if (xVelocity < -MAXVEL) {
            this.xVelocity = -MAXVEL;
        } else {
            this.xVelocity = xVelocity;
        }
    }

    /**
     * Sets y-axis velocity of ball.
     * 
     * @param yVelocity of ball.
     */
    public void setyVel(double yVelocity) {
        if (yVelocity > MAXVEL) {
            this.yVelocity = MAXVEL;
        } else if (yVelocity < -MAXVEL) {
            this.yVelocity = -MAXVEL;
        } else {
            this.yVelocity = yVelocity;
        }
    }

    /**
     * Sets x-axis position of ball.
     * 
     * @param xPosition of ball.
     */
    public void setxPos(double xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Sets y-axis position of ball.
     * 
     * @param yPosition of ball.
     */
    public void setyPos(double yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Getter method for radius of ball.
     * 
     * @return radius length.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Getter method for x-position of ball.
     * is actually different from stored xPosition...
     *
     * @return x position.
     */
    public double getxPos() {
        return xPosition + Config.getTableBuffer();
    }

    /**
     * Getter method for y-position of ball.
     * 
     * @return y position.
     */
    public double getyPos() {
        return yPosition + Config.getTableBuffer();
    }

    /**
     * Getter method for starting x-position of ball.
     * 
     * @return starting x position.
     */
    public double getStartXPos() {
        return startX;
    }

    /**
     * Getter method for starting y-position of ball.
     * 
     * @return starting y position.
     */
    public double getStartYPos() {
        return startY;
    }

    /**
     * Getter method for starting mass of ball.
     * 
     * @return mass.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Getter method for colour of ball.
     * 
     * @return colour.
     */
    public Paint getColour() {
        return colour;
    }

    /**
     * Getter method for x-axis velocity of ball.
     * 
     * @return x velocity.
     */
    public double getxVel() {
        return xVelocity;
    }

    /**
     * Getter method for y-axis velocity of ball.
     * 
     * @return y velocity.
     */
    public double getyVel() {
        return yVelocity;
    }

    /**
     * Getter method for whether ball is cue ball.
     * 
     * @return true if ball is cue ball.
     */
    public boolean isCue() {
        return isCue;
    }

    /**
     * Getter method for whether ball is active.
     * 
     * @return true if ball is active.
     */
    public boolean isActive() {
        return isActive;
    }


    /**
     * used for deep copy, supplement to constructor
     * @param active the ball is dead or not
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /** setter */
    public void setStartX(double startX) {
        this.startX = startX;
    }

    /** setter */
    public void setStartY(double startY) {
        this.startY = startY;
    }

    /** setter */
    public void setColour(Paint colour) {
        this.colour = colour;
    }

    /** setter */
    public void setStrategy(PocketStrategy strategy) {
        this.strategy = strategy;
    }

    /** getter */
    public PocketStrategy getStrategy() {
        return strategy;
    }

    /** getter without table buffer */
    public double getxPosition() {
        return xPosition;
    }

    /** getter without table buffer */
    public double getyPosition() {
        return yPosition;
    }

    private Ball(Ball ball) {
        this.colour = ball.getColour();
        this.xPosition = ball.getxPosition();
        this.yPosition = ball.getyPosition();
        this.xVelocity = ball.getxVel();
        this.yVelocity = ball.getyVel();
        this.mass = ball.getMass();
        this.radius = ball.getRadius();
        this.isCue = ball.isCue();
        this.startX = ball.getStartXPos();
        this.startY = ball.getStartYPos();
        this.isActive = ball.isActive();

        // the copy
        this.strategy = ball.getStrategy().copy();
    }

    /**
     * used for Memento
     *
     * @return deep copy
     */
    public Ball copy() {
        return new Ball(this);
    }

    /** setter for cheat */
    public void setLives(int lives) {
        strategy.setLives(lives);
    }
}

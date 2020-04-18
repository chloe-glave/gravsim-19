package classes;

import classes.driver.Driver;
import interfaces.Collectible;
import interfaces.PhysicalBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Random;

/**
 * Simulates a collectible coin in the space simulation.
 */
public class Coin implements Collectible, PhysicalBody {
    /* The value of the Coin */
    private int value;
    /* The shape of the Coin */
    private Ellipse shape;

    /**
     * Constructs a Coin object.
     *
     * @param value The value of the Coin.
     * @param shape The Shape of the Coin.
     */
    public Coin(int value, Ellipse shape) {
        this.value = value;
        this.shape = shape;
    }

    /**
     * Constructs the Coin with default values.
     */
    public Coin() {
        final int appearanceRange = 200;
        Ellipse newCoin = new Ellipse(new Random().nextInt(Driver.WINDOW_WIDTH),
                new Random().nextInt(Driver.WINDOW_HEIGHT - appearanceRange),
                5, 7);
        this.value = 1;
        this.shape = newCoin;
        this.shape.setFill(Color.GOLD);
    }

    /**
     * Sets the value of the Coin.
     *
     * @param value The value to be set.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Sets the shape of the Coin.
     *
     * @param shape The shape to be set.
     */
    public void setShape(Ellipse shape) {
        this.shape = shape;
    }

    /**
     * Gets the current value of the Coin.
     *
     * @return The value of the Coin.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Gets the current shape of the Coin.
     *
     * @return The shape of the Coin.
     */
    @Override
    public Ellipse getShape() {
        return shape;
    }

    /**
     * Sets the x values of shape.
     *
     * @param x The value for it to be changed to.
     */
    @Override
    public void setX(double x) {
        shape.setCenterX(x);
    }

    /**
     * Sets the y values of the shape.
     *
     * @param y The value for it to be changed to.
     */
    @Override
    public void setY(double y) {
        shape.setCenterY(y);
    }

    /**
     * Gets the x values of the shape.
     *
     * @return The x value of the shape.
     */
    @Override
    public double getX() {
        return shape.getCenterX();
    }

    /**
     * Gets the y value of the shape.
     *
     * @return The y value of the shapes.
     */
    @Override
    public double getY() {
        return shape.getCenterY();
    }

    /**
     * Gets the mass of the Coin. A Coin does not have a mass.
     *
     * @return 0, equal to nothing.
     */
    @Override
    public double getMass() {
        return 0;
    }

    /**
     * Gets the destructibility of a Coin. A coin does not have destructibility.
     *
     * @return False, equal to nothing. 
     */
    @Override
    public boolean getDestructible() {
        return false;
    }
}

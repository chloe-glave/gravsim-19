package classes;

import interfaces.Collectible;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Simulates a collectible coin in the space simulation.
 */
public class Coin implements Collectible {
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
        Ellipse newCoin = new Ellipse(10, 7.5, 5, 5);
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

    @Override
    public double getX() {
        return shape.getCenterX();
    }

    @Override
    public double getY() {
        return shape.getCenterY();
    }

}

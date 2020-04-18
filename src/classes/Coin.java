package classes;

import classes.driver.Driver;
import interfaces.Collectible;
import interfaces.PhysicalBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Objects;
import java.util.Random;

/**
 * Simulates a collectible coin in the space simulation.
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Coin implements Collectible, PhysicalBody {
    /* The value of the Coin */
    private static final int VALUE = 1;
    /* The shape of the Coin */
    private Ellipse shape;

    /**
     * Constructs the Coin with default values.
     */
    public Coin() {
        final int appearanceRange = 200;
        final int xRadius = 5;
        final int yRadius = 7;
        this.shape = new Ellipse(new Random().nextInt(Driver.WINDOW_WIDTH),
                new Random().nextInt(Driver.WINDOW_HEIGHT - appearanceRange),
                xRadius, yRadius);
        this.shape.setFill(Color.GOLD);
    }

    /**
     * Gets the current value of the Coin.
     *
     * @return The value of the Coin.
     */
    @Override
    public int getValue() {
        return VALUE;
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

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Coin.
     */
    @Override
    public String toString() {
        return "Coin{" +
                "shape=" + shape +
                '}';
    }

    /**
     * Checks if the object passed into the method is:
     * 1. Not null.
     * 2. Same object (Address-wise).
     * 3. The same object type.
     * 4. Has the same values within.
     *
     * @param o The value being compared with. It is an Object type value.
     * @return A boolean signifying if the object passed into method is the
     * same as what it being checked against.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coin)) return false;
        Coin coin = (Coin) o;
        return Objects.equals(getShape(), coin.getShape());
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getShape());
    }
}

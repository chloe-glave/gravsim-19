package classes;

import classes.driver.Driver;
import interfaces.StaticBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Objects;
import java.util.Random;

/**
 * Simulates a Star.
 *
 * @author Janelle Kwok
 * @author Chloe Glave
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Star implements StaticBody {
    /* Private constant for a Random object. */
    private static final Random RANDOM = new Random();

    /* The radius of a default star. */
    private static final int STAR_RADIUS = 15000;

    /* The mass of a default star. */
    private static final double STAR_MASS = 19.89;

    /* The radius for the Star in kilometers(km).*/
    private final int radius;

    /* The mass for the Star in 10^24 kilograms (kg).*/
    private final double mass;

    /* The display for Star. */
    private final Circle shape;

    /* Determines whether or not the Star is destructible. */
    private final boolean destructible;


    /**
     * Constructs a Star object with an assigned destructibility.
     *
     * @param radius The radius of the star.
     * @param mass The mass of the star.
     * @param destructible If the Star is destructible or not.
     **/
    public Star(int radius, double mass, boolean destructible) {
        final int circleRadiusModifier = 500;
        final int shapeRadius = radius / circleRadiusModifier;
        final int maxYSpawnRange = 640;
        final double minMassValue = 15.0;
        if (radius < circleRadiusModifier) {
            radius = circleRadiusModifier;
        }
        this.radius = radius;
        if (mass < minMassValue) {
            mass = minMassValue;
        }
        this.mass = mass;
        this.shape = new Circle(RANDOM.nextInt(Driver.WINDOW_WIDTH
                - (shapeRadius * 2)) + shapeRadius,
                RANDOM.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius,
                shapeRadius, Color.YELLOW);
        this.destructible = destructible;
    }

    /**
     * Constructs a Star object with default values.
     */
    public Star() {
        this(STAR_RADIUS, STAR_MASS, false);
    }

    /**
     * Gets the radius of the Star object.
     *
     * @return The Star's current radius.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Gets the mass of the Star object.
     *
     * @return The Star's current mass.
     */
    @Override
    public double getMass() {
        return mass;
    }

    /**
     * Gets the destructibility of the Star object.
     *
     * @return The Star's current destructibility.
     */
    @Override
    public boolean getDestructible() {
        return destructible;
    }

    /**
     * Gets the shape of the Star object.
     *
     * @return The Star's current shape.
     */
    @Override
    public Shape getShape() {
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
     * Gets the current x position of the star.
     * @return the current x position
     */
    @Override
    public double getX() {
        return shape.getCenterX();
    }

    /**
     * Gets the current y position of the star.
     * @return the current y position
     */
    @Override
    public double getY() {
        return shape.getCenterY();
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
        if (!(o instanceof Star)) return false;
        Star star = (Star) o;
        return getRadius() == star.getRadius() &&
                Double.compare(star.getMass(), getMass()) == 0 &&
                getDestructible() == star.getDestructible() &&
                Objects.equals(getShape(), star.getShape());
    }

    /**
     * Creates the hashcode for each instantiated object.
     * This hashcode will be based on the attributes in the object.
     *
     * @return The hashcode for the current object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius(), getMass(), getShape(), getDestructible());
    }

    /**
     * Converts the attributes in the class into a String object and
     * displays them in a informative manner.
     *
     * @return A String representation of the attributes within Star.
     */
    @Override
    public String toString() {
        return "Star{" +
                "radius=" + radius +
                ", mass=" + mass +
                ", shape=" + shape +
                ", destructible=" + destructible +
                '}';
    }
}

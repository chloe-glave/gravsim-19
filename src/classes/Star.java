package classes;

import classes.driver.Driver;
import interfaces.StaticBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

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
    /* The radius for the Star in kilometers(km)*/
    private int radius;
    /* The mass for the Star in 10^24 kilograms (kg)*/
    private double mass;
    /* The display for Star. */
    private Circle shape;
    /* Determines whether or not the Star is destructible. */
    private boolean destructible;

    private static final Random random = new Random();

    /**
     * Constructs a Star object with an assigned destructibility.
     *
     * @param radius The radius of the star.
     * @param mass The mass of the star.
     * @param destructible If the Star is destructible or not.
     * @param colour The colour of the Star.
     **/
    public Star(int radius, double mass, boolean destructible, Color colour) {
        final int circleRadiusModifier = 500;
        final int shapeRadius = radius / circleRadiusModifier;
        final int maxYSpawnRange = 640;
        final double minMassValue = 0.01;
        if (radius < circleRadiusModifier) {
            radius = circleRadiusModifier;
        }
        this.radius = radius;
        if (mass < 0.0) {
            mass = minMassValue;
        }
        this.mass = mass;
        this.shape = new Circle(random.nextInt(Driver.WINDOW_WIDTH
                - (shapeRadius * 2)) + shapeRadius,
                random.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius,
                shapeRadius, Color.YELLOW);
        this.destructible = destructible;
    }

    /**
     * Constructs a Star object with default values.
     */
    public Star() {
        final int sunRadius = 15000;
        final int circleRadiusModifier = 500;
        final int shapeRadius = sunRadius / circleRadiusModifier;
        final int maxYSpawnRange = 640;
        final double sunsMass = 19.89;
        this.radius = sunRadius;
        this.mass = sunsMass;
        this.shape = new Circle(random.nextInt(Driver.WINDOW_WIDTH
                - (shapeRadius * 2)) + shapeRadius,
                random.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius,
                shapeRadius, Color.YELLOW);
        this.destructible = true;
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


}

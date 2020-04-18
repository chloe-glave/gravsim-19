package classes;

import classes.driver.Driver;
import interfaces.DynamicBody;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import java.util.Random;

/**
 * Simulates a planet.
 *
 * @author Janelle Kwok
 * @author Chloe Glave
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Planet implements DynamicBody {

    private static final Random RANDOM = new Random();

    /* The radius is stored in kilometers(km) */
    private final int radius;

    /* Mass stored in 10^24 kilograms (kg).
    * If mass = 0.35 then the mass of that planet would be 3.5 * 10^23 */
    private final double mass;

    /* The shape of the planet */
    private final Circle shape;

    /* The velocity of the planets x direction */
    private double vx;

    /* The velocity of the planets y direction */
    private double vy;

    /* A boolean of whether the planet is destructible */
    private final boolean destructible;

    /**
     * Constructs a planet with default values.
     */
    public Planet() {
        final double velocityModifier = 4.0;
        final int circleRadiusModifier = 500;
        final int planetsRadiusBound = 6000;
        final int planetMassModifier = 1000;
        int planetsRadius = RANDOM.nextInt(planetsRadiusBound) + planetsRadiusBound;
        final int shapeRadius = planetsRadius / circleRadiusModifier;
        final double planetsMass = (planetsRadius * 1.0) / planetMassModifier;
        final int maxYSpawnRange = 640;
        final int colourBound = 255;
        this.radius = planetsRadius;
        this.mass = planetsMass;
        this.shape = new Circle(RANDOM.nextInt(Driver.WINDOW_WIDTH
                - (shapeRadius * 2)) + shapeRadius,
                RANDOM.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius, shapeRadius,
                Color.rgb(RANDOM.nextInt(colourBound),
                        RANDOM.nextInt(colourBound), RANDOM.nextInt(colourBound)));
        this.vx = RANDOM.nextDouble() * velocityModifier;
        this.vy = RANDOM.nextDouble() * velocityModifier;
        destructible = true;
    }

    /**
     * Constructs a planet with an assigned shape.
     * @param radius the radius of the planet stored in km
     * @param mass the mass of the planet stored in 10^24 kg
     * @param vx the x direction velocity of the planet
     * @param vy the y direction velocity of the planet
     * @param destructible boolean determining if the planet can be destroyed
     */
    public Planet(int radius, double mass, double vx, double vy, boolean destructible) {
        final int circleRadiusModifier = 500;
        final int colourBound = 255;
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
        this.shape = new Circle(RANDOM.nextInt(Driver.WINDOW_WIDTH
                - (shapeRadius * 2)) + shapeRadius,
                RANDOM.nextInt(maxYSpawnRange - (shapeRadius * 2)) + shapeRadius,
                shapeRadius, Color.rgb(RANDOM.nextInt(colourBound),
                RANDOM.nextInt(colourBound), RANDOM.nextInt(colourBound)));
        this.vx = vx;
        this.vy = vy;
        this.destructible = destructible;
    }

    /**
     * Gets the radius of the planet.
     * @return the radius of the planet
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Gets the planets x velocity.
     * @return the planets x velocity
     */
    @Override
    public double getVx() {
        return vx;
    }

    /**
     * Gets the planets y velocity.
     * @return the planets y velocity.
     */
    @Override
    public double getVy() {
        return vy;
    }

    /**
     * Adds a double number to the velocity in the x direction.
     * @param num the number to add to vx
     */
    @Override
    public void addVx(double num) {
        vx += num;
    }

    /**
     * Adds a double number to the velocity in the y direction.
     * @param num the number to add to vy
     */
    @Override
    public void addVy(double num) {
        vy += num;
    }

    /**
     * Updates the planets X and Y centers by the Velocity in the X and Y directions.
     */
    @Override
    public void move() {
        shape.setCenterX(shape.getCenterX() + vx);
        shape.setCenterY(shape.getCenterY() + vy);
    }

    /**
     * Gets the mass of the planet.
     * @return the mass of the planet
     */
    @Override
    public double getMass() {
        return mass;
    }

    /**
     * Gets the boolean for the planets destructibility.
     * @return the boolean for destructibility
     */
    @Override
    public boolean getDestructible() {
        return destructible;
    }

    /**
     * Gets the Shape of the planet.
     * @return the Shape of the planet
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
     * Sets the y values of shape.
     *
     * @param y The value for it to be changed to.
     */
    @Override
    public void setY(double y) {
        shape.setCenterX(y);
    }

    /**
     * Gets the current x position of the planet.
     * @return the x position.
     */
    @Override
    public double getX() {
        return shape.getCenterX();
    }

    /**
     * Gets the current y position of the planet.
     * @return the y position
     */
    @Override
    public double getY() {
        return shape.getCenterY();
    }
}

package classes;

import interfaces.DynamicBody;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;


public class Planet implements DynamicBody {

    /* The radius is stored in kilometers(km) */
    private int radius;

    /* Mass stored in 10^24 kilograms (kg).
    * If mass = 0.35 then the mass of that planet would be 3.5 * 10^23 */
    private double mass;

    /* The shape of the planet */
    private Circle shape;

    /* The velocity of the planets x direction */
    private double vx;

    /* The velocity of the planets y direction */
    private double vy;

    /* A boolean of whether the planet is destructible */
    private boolean destructible;

    /**
     * Constructs a planet with default values.
     */
    public Planet() {
        final int defaultVelocity = 5;
        final int defaultCircleRadius = 10;
        final int defaultCircleLocation = 25;
        final int earthsRadius = 6371;
        final double earthsMass = 5.972;
        Circle newShape = new Circle(defaultCircleRadius,
                defaultCircleLocation, defaultCircleLocation, Color.BLUE);
        this.radius = earthsRadius;
        this.mass = earthsMass;
        this.shape = newShape;
        this.vx = defaultVelocity;
        this.vy = defaultVelocity;
        destructible = true;
    }

    /**
     * Constructs a planet with an assigned destructibility.
     * @param radius the radius of the planet stored in km
     * @param mass the mass of the planet stored in 10^24 kg
     * @param shape the shape of the planet
     * @param vx the x direction velocity of the planet
     * @param vy the y direction velocity of the planet
     * @param destructible boolean determining if the planet can be destroyed
     */
    public Planet(int radius, double mass, Circle shape,
                  double vx, double vy, boolean destructible) {
        this.radius = radius;
        this.mass = mass;
        this.shape = shape;
        this.vx = vx;
        this.vy = vy;
        this.destructible = destructible;
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
     * Updates the planets X and Y centers by the Velocity in the X and Y directions.
     */
    @Override
    public void move() {
        shape.setCenterY(shape.getCenterX() + vx);
        shape.setCenterY(shape.getCenterX() + vy);
    }

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
}

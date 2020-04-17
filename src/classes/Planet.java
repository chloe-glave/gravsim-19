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
    private Shape shape;

    /* The velocity of the planets x direction */
    private double vx;

    /* The velocity of the planets y direction */
    private double vy;

    /* A boolean of whether the planet is destructible */
    private boolean destructible;

    /**
     * Constructs a planet with default values.
     */
    public Planet () {
        Circle newShape = new Circle(10, 10, 5, Color.BLUE);
        this.radius = 6371;
        this.mass = 5.972;
        this.shape = newShape;
        this.vx = 5;
        this.vy = 5;
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
    public Planet(int radius, double mass, Shape shape, double vx,
                   double vy, boolean destructible) {
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
     * Moves the planet.
     */
    @Override
    public void move() {

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

package classes;

import interfaces.StaticBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Simulates a Star.
 */
public class Star implements StaticBody {
    /* The radius for the Star */
    private int radius;
    /* The mass for the Star */
    private double mass;
    /* The display for Star. */
    private Ellipse shape;
    /* Determines whether or not the Star is destructible. */
    private boolean destructible;

    /**
     * Constructs a Star object with an assigned destructibility.
     *
     * @param radius The radius of the star.
     * @param mass The mass of the star.
     * @param shape The shape of the star. This will determine how it is displayed.
     * @param destructible If the Star is destructible or not.
     * @param colour The colour of the Star.
     **/
    public Star(int radius, double mass, Ellipse shape, boolean destructible, Color colour) {
        this.radius = radius;
        this.mass = mass;
        this.shape = shape;
        this.destructible = destructible;
        this.shape.setFill(colour);

    }

    /**
     * Constructs a Star object with default values.
     */

    public Star() {
        Ellipse newShape = new Ellipse(10, 10, 5, 5);
        this.radius = 5;
        this.mass = 1.989000;
        this.shape = newShape;
        this.destructible = true;
        this.shape.setFill(Color.YELLOW);
    }

    /**
     * Sets the radius of the Star object.
     *
     * @param radius The radius to be set.
     */

    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Sets the mass of the Star object.
     *
     * @param mass The mass to be set.
     */

    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Sets the Ellipse shape of the Star object.
     *
     * @param shape The shape to be set.
     */

    public void setShape(Ellipse shape) {
        this.shape = shape;
    }

    /**
     * Sets the destructibility of the Star object.
     *
     * @param destructible The destructibility to be set.
     */

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
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


}

package Classes;

import interfaces.StaticBody;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Simulates a Star object.
 */
public class Star implements StaticBody {
    private int radius;
    private double mass;
    private Ellipse shape;
    private boolean destructible;

    public Star(int radius, double mass, Ellipse shape, boolean destructible, Color color) {
        this.radius = radius;
        this.mass = mass;
        this.shape = shape;
        this.destructible = destructible;
        this.shape.setFill(color);

    }

    //default constructor
    public Star() {
        Ellipse newShape = new Ellipse(10, 10, 10, 10);
        this.radius = 5;
        this.mass = 1.989000;
        this.shape = newShape;
        this.destructible = true;
        this.shape.setFill(Color.YELLOW);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setShape(Ellipse shape) {
        this.shape = shape;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public boolean getDestructible() {
        return destructible;
    }

    @Override
    public Shape getShape() {
        return shape;
    }


}

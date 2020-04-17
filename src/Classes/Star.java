package Classes;

import interfaces.StaticBody;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class Star implements StaticBody {
    private final int radius;
    private final int mass;
    private final Ellipse shape;
    private final boolean destructible;

    public Star(int radius, int mass, Ellipse shape, boolean destructible) {
        this.radius = radius;
        this.mass = mass;
        this.shape = shape;
        this.destructible = destructible;

    }

    @Override
    public int getMass() {
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

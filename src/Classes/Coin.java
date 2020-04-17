package Classes;

import interfaces.Collectible;
import javafx.scene.shape.Shape;

public class Coin implements Collectible {
    private int value;
    private Shape shape;

    public Coin


    @Override
    public int collect() {
        return value;
    }

    @Override
    public Shape getShape() {
        return shape;
    }
}

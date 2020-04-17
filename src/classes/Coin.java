package classes;

import interfaces.Collectible;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Simulates a collectible coin in the space simulation.
 */
public class Coin implements Collectible {
    /* The value of the Coin */
    private int value;
    /* The shape of the Coin */
    private Ellipse shape;


    public Coin(int value, Ellipse shape) {
        this.value = value;
        this.shape = shape;
    }

    public Coin() {
        Ellipse newCoin = new Ellipse(10, 7.5, 5, 5);
        this.value = 1;
        this.shape = newCoin;
        this.shape.setFill(Color.GOLD);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setShape(Ellipse shape) {
        this.shape = shape;
    }

    @Override
    public int collect() {
        return value;
    }

    @Override
    public Ellipse getShape() {
        return shape;
    }
}

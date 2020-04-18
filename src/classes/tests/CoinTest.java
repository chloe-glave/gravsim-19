package classes.tests;

import classes.Coin;
import javafx.scene.shape.Ellipse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class CoinTest {

    private Coin defaultCoin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() {
        defaultCoin = new Coin();
    }

    @Test
    public void getValueReturnsProperCoinValue() {
        assertEquals(defaultCoin.getValue(), 1);
    }

    @Test
    public void getShapeReturnsANonNullValue() {
        assertNotNull(defaultCoin.getShape());
    }

    @Test
    public void setXPlacesCoinInProperLocation() {
        defaultCoin.setX(50.5);
        Ellipse coinShape = defaultCoin.getShape();
        assertEquals(defaultCoin.getX(), coinShape.getCenterX(), 0.05);
    }

    @Test
    public void setYPlacesCoinInProperLocation() {
        defaultCoin.setY(50.5);
        Ellipse coinShape = defaultCoin.getShape();
        assertEquals(defaultCoin.getY(), coinShape.getCenterY(), 0.05);
    }

    @Test
    public void getXReturnsTheProperValue() {
        Ellipse coinShape = defaultCoin.getShape();
        assertEquals(defaultCoin.getX(), coinShape.getCenterX(), 0.05);
    }

    @Test
    public void getYReturnsTheProperValue() {
        Ellipse coinShape = defaultCoin.getShape();
        assertEquals(defaultCoin.getY(), coinShape.getCenterY(), 0.05);
    }

    @Test
    public void getMassShouldReturnZeroButIsNeededBecauseOfPhysicalBodyInterface() {
        assertEquals(defaultCoin.getMass(), 0, 0.01);
    }

    @Test
    public void getDestructibleShouldReturnFalseButIsNeededBecauseOfPhysicalBodyInterface() {
        assertEquals(defaultCoin.getMass(), 0, 0.01);
    }
}

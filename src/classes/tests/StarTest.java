package classes.tests;

import classes.Star;
import javafx.scene.shape.Circle;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class StarTest {

    private Star defaultStar;
    private Star testStar;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() {
        defaultStar = new Star();
        testStar = new Star(0, 0, true);
    }

    @Test
    public void getRadiusReturnsProperValueForDefaultStar() {
        assertEquals(defaultStar.getRadius(), 15000);
    }

    @Test
    public void getRadiusReturnsProperValueForTestStar() {
        assertEquals(testStar.getRadius(), 500);
    }

    @Test
    public void getMassReturnsProperValueForDefaultStar() {
        assertEquals(defaultStar.getMass(), 19.89, 0.1);
    }

    @Test
    public void getMassReturnsProperValueForTestStar() {
        assertEquals(testStar.getMass(), 15.0, 0.1);
    }

    @Test
    public void getDestructibleReturnsProperValueForDefaultStar() {
        assertFalse(defaultStar.getDestructible());
    }

    @Test
    public void getDestructibleReturnsProperValueForTestStar() {
        assertTrue(testStar.getDestructible());
    }

    @Test
    public void getShapeReturnsANonNullForDefaultStar() {
        assertNotNull(defaultStar.getShape());
    }

    @Test
    public void getShapeReturnsANonNullForTestStar() {
        assertNotNull(testStar.getShape());
    }

    @Test
    public void setXChangesXLocationForDefaultStar() {
        defaultStar.setX(50.5);
        assertEquals(defaultStar.getX(), 50.5, 0.05);
    }

    @Test
    public void setYChangesYLocationForDefaultStar() {
        defaultStar.setY(50.5);
        assertEquals(defaultStar.getY(), 50.5, 0.05);
    }

    @Test
    public void setXChangesXLocationForTestStar() {
        testStar.setX(50.5);
        assertEquals(testStar.getX(), 50.5, 0.05);
    }

    @Test
    public void setYChangesYLocationForTestStar() {
        testStar.setY(50.5);
        assertEquals(testStar.getY(), 50.5, 0.05);
    }

    @Test
    public void getXReturnsProperValueForDefaultStar() {
        Circle star = (Circle) defaultStar.getShape();
        assertEquals(defaultStar.getX(), star.getCenterX(), 0.05);
    }

    @Test
    public void getYReturnsProperValueForDefaultStar() {
        Circle star = (Circle) defaultStar.getShape();
        assertEquals(defaultStar.getY(), star.getCenterY(), 0.05);
    }

    @Test
    public void getXReturnsProperValueForTestStar() {
        Circle star = (Circle) testStar.getShape();
        assertEquals(testStar.getX(), star.getCenterX(), 0.05);
    }

    @Test
    public void getYReturnsProperValueForTestStar() {
        Circle star = (Circle) testStar.getShape();
        assertEquals(testStar.getY(), star.getCenterY(), 0.05);
    }

}

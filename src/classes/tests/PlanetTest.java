package classes.tests;

import classes.Planet;
import javafx.scene.shape.Circle;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.rules.*;

public class PlanetTest {

    private Planet defaultPlanet;
    private Planet testPlanet;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() {
        defaultPlanet = new Planet();
        testPlanet = new Planet(0, 0, -2.123, 5.345, false);
    }

    @Test
    public void getVxReturnsProperValueForDefaultPlanet(){
        assertEquals(5, defaultPlanet.getVx(), 0.05);
    }

    @Test
    public void getVyReturnsProperValueForDefaultPlanet(){
        assertEquals(5, defaultPlanet.getVy(), 0.05);
    }

    @Test
    public void getVxReturnsProperValueForTestPlanet(){
        assertEquals(-2.123, testPlanet.getVx(), 0.05);
    }

    @Test
    public void getVyReturnsProperValueForTestPlanet(){
        assertEquals(5.345, testPlanet.getVy(), 0.05);
    }

    @Test
    public void addVxAddsProperlyToVxOnDefaultPlanet(){
        defaultPlanet.addVx(-3.2);
        assertEquals(1.8, defaultPlanet.getVx(), 0.05);
    }

    @Test
    public void addVyAddsProperlyToVyOnDefaultPlanet(){
        defaultPlanet.addVy(3.2);
        assertEquals(8.2, defaultPlanet.getVy(), 0.05);
    }

    @Test
    public void addVxAddsProperlyToVxOnTestPlanet(){
        testPlanet.addVx(-3.2);
        assertEquals(-5.323, testPlanet.getVx(), 0.05);
    }

    @Test
    public void addVyAddsProperlyToVyOnTestPlanet(){
        testPlanet.addVy(3.2);
        assertEquals(8.545, testPlanet.getVy(), 0.05);
    }

    @Test
    public void moveProperlyAffectsDefaultPlanetsCenterX() {
        Circle oldDefaultPlanetCircle = (Circle) defaultPlanet.getShape();
        double oldXPosition = oldDefaultPlanetCircle.getCenterX();
        defaultPlanet.move();
        Circle newDefaultPlanetCircle = (Circle) defaultPlanet.getShape();
        double newXPosition = newDefaultPlanetCircle.getCenterX();
        assertEquals(oldXPosition + defaultPlanet.getVx(), newXPosition, 0.05);
    }

    @Test
    public void moveProperlyAffectsDefaultPlanetsCenterY() {
        Circle oldDefaultPlanetCircle = (Circle) defaultPlanet.getShape();
        double oldYPosition = oldDefaultPlanetCircle.getCenterY();
        defaultPlanet.move();
        Circle newDefaultPlanetCircle = (Circle) defaultPlanet.getShape();
        double newYPosition = newDefaultPlanetCircle.getCenterY();
        assertEquals(oldYPosition + defaultPlanet.getVy(), newYPosition, 0.05);
    }

    @Test
    public void moveProperlyAffectsTestPlanetsCenterX() {
        Circle oldTestPlanetCircle = (Circle) testPlanet.getShape();
        double oldXPosition = oldTestPlanetCircle.getCenterX();
        testPlanet.move();
        Circle newTestPlanetCircle = (Circle) testPlanet.getShape();
        double newXPosition = newTestPlanetCircle.getCenterX();
        assertEquals(oldXPosition + testPlanet.getVx(), newXPosition, 0.05);
    }

    @Test
    public void moveProperlyAffectsTestPlanetsCenterY() {
        Circle oldTestPlanetCircle = (Circle) testPlanet.getShape();
        double oldYPosition = oldTestPlanetCircle.getCenterY();
        testPlanet.move();
        Circle newTestPlanetCircle = (Circle) testPlanet.getShape();
        double newYPosition = newTestPlanetCircle.getCenterY();
        assertEquals(oldYPosition + testPlanet.getVy(), newYPosition, 0.05);
    }

    @Test
    public void getMassProperlyReturnsTheCorrectValueForDefaultPlanet() {
        assertEquals(defaultPlanet.getMass(), 5.972, 0.05);
    }

    @Test
    public void getMassProperlyReturnsTheCorrectValueForTestPlanet() {
        assertEquals(testPlanet.getMass(), 0.01, 0.05);
    }

    @Test
    public void getDestructibleReturnsTheCorrectBooleanForDefaultPlanet() {
        assertTrue(defaultPlanet.getDestructible());
    }

    @Test
    public void getDestructibleReturnsTheCorrectBooleanForTestPlanet() {
        assertFalse(testPlanet.getDestructible());
    }

    @Test
    public void getShapeReturnsObjectAndNotNullForDefaultPlanet() {
        assertNotNull(defaultPlanet.getShape());
    }

    @Test
    public void getShapeReturnsObjectAndNotNullForTestPlanet() {
        assertNotNull(defaultPlanet.getShape());
    }

    @Test
    public void getXReturnsProperValueForDefaultPlanet() {
        Circle locationCopy = (Circle) defaultPlanet.getShape();
        assertEquals(defaultPlanet.getX(), locationCopy.getCenterX(), 0.05);
    }

    @Test
    public void getYReturnsProperValueForDefaultPlanet() {
        Circle locationCopy = (Circle) defaultPlanet.getShape();
        assertEquals(defaultPlanet.getY(), locationCopy.getCenterY(), 0.05);
    }

    @Test
    public void getXReturnsProperValueForTestPlanet() {
        Circle locationCopy = (Circle) defaultPlanet.getShape();
        assertEquals(defaultPlanet.getX(), locationCopy.getCenterX(), 0.05);
    }

    @Test
    public void getYReturnsProperValueForTestPlanet() {
        Circle locationCopy = (Circle) testPlanet.getShape();
        assertEquals(testPlanet.getY(), locationCopy.getCenterY(), 0.05);
    }

}

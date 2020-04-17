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
    public void setUp() throws Exception {
        defaultPlanet = new Planet();
        testPlanet = new Planet(0, 0, -2.123, 5.345, false);
    }

    @Test
    public void getVXReturnsProperValueForDefaultPlanet() {
        assertEquals(defaultPlanet.getVx(), 5, 0.05);
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

}

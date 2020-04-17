package classes.tests;

import classes.Planet;
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
        testPlanet = new Planet(0, 0, -2.123, 5.345, true);
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

}

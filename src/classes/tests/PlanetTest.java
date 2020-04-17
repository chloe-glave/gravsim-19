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
    public void getVXReturnsProperValueForDefaultPlanet(){
        assertEquals(defaultPlanet.getVx(), 5, 0.05);
    }

}

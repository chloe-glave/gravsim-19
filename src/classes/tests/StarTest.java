package classes.tests;

import classes.Star;
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

}

package classes;

import classes.driver.Driver;
import interfaces.SpatialEntity; // INTERFACES WITH IS-A RELATIONSHIPS
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Handles the simulation.
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Environment {

    private static ArrayList<SpatialEntity> bodies;
    private static PhysicsHandler simulator;
    private final Group bodyShapes;
    private int coinAmount;

    /**
     * Constructs an Environment.
     */
    public Environment() {
        bodies = new ArrayList<>(); // 2/2 TYPES OF COLLECTIONS
        simulator = new PhysicsHandler(this);
        bodyShapes = new Group();
        coinAmount = 0;
    }

    /**
     * Sets the coin amount in the Environment.
     *
     * @param coinAmount The coin amount to be changed to.
     */
    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }

    /**
     * Accesses the bodyShapes Group.
     *
     * @return bodyShapes.
     */
    public Group getBodyShapes() {
        return bodyShapes;
    }

    /**
     * Gets the coin amount for the Environment.
     *
     * @return The current amount of coins.
     */
    public int getCoinAmount() {
        return coinAmount;
    }

    /**
     * Creates a Planet and adds it to the Environment's bodies ArrayList.
     */
    public void createPlanet() {
        Planet planet = new Planet();
        bodies.add(planet);
        simulator.addBody(planet);

        bodyShapes.getChildren().add(planet.getShape());
    }

    /**
     * Creates a Star and adds it to the Environment's bodies ArrayList.
     */
    public void createStar() {
        Star star = new Star();
        bodies.add(star);
        simulator.addBody(star);

        bodyShapes.getChildren().add(star.getShape());
    }

    /**
     * Randomly generates and places coins in the JavaFX environment.
     */
    public void generateCoins() {
        final int numberOfCoins = 10;
        for (int index = 0; index < numberOfCoins; index++) {
            Coin coin = new Coin();
            bodies.add(coin);
            simulator.addBody(coin);

            bodyShapes.getChildren().add(coin.getShape());
        }
    }

    /**
     * Removes a given SpatialEntity from the bodies ArrayList and from the screen display.
     *
     * @param body the SpatialEntity (Body) to remove.
     */
    public void removeBody(SpatialEntity body) {
        if (body.getClass().equals(Coin.class)) {
            System.out.printf("Current coin amount is now: %d\n",
                    getCoinAmount() + 1);
            setCoinAmount(getCoinAmount() + 1);
            Driver.updateScoreText("Score: " + getCoinAmount());
        }
        bodies.remove(body);
        bodyShapes.getChildren().remove(body.getShape());
    }

    @Override
    public String toString() {
        return "Environment{" +
                "bodyShapes=" + bodyShapes +
                ", coinAmount=" + coinAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Environment)) return false;
        Environment that = (Environment) o;
        return getCoinAmount() == that.getCoinAmount() &&
                Objects.equals(getBodyShapes(), that.getBodyShapes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBodyShapes(), getCoinAmount());
    }
}

package classes;

import interfaces.SpatialEntity;
import javafx.scene.Group;

import java.util.ArrayList;

/**
 * Handles the simulation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Environment {

    private static ArrayList<SpatialEntity> bodies;
    private static PhysicsHandler simulator;
    private Group bodyShapes;

    public Group getBodyShapes() {
        return bodyShapes;
    }

    /**
     * Constructs an Environment.
     */
    public Environment() {
        bodies = new ArrayList<SpatialEntity>();
        simulator = new PhysicsHandler();
        bodyShapes = new Group();
    }

    /**
     * Creates a Planet and adds it to the Environment's bodies ArrayList.
     *
     * @return the newly created Planet.
     */
    public Planet createPlanet() {
        Planet planet = new Planet();
        bodies.add(planet);
        simulator.addBody(planet);

        bodyShapes.getChildren().add(planet.getShape());

        return planet;
    }

    /**
     * Creates a Star and adds it to the Environment's bodies ArrayList.
     *
     * @return the newly created Star.
     */
    public Star createStar() {
        Star star = new Star();
        bodies.add(star);
        simulator.addBody(star);

        bodyShapes.getChildren().add(star.getShape());

        return star;
    }

    /**
     * Creates objects and adds them to the Bodies ArrayList to be used.
     */
    public void generateBodies() { // todo: do we still need this? creates one default planet and star
        createStar();
        createPlanet();
    }

}

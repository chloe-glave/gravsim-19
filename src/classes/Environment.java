package classes;

import interfaces.DynamicBody;
import interfaces.PhysicalBody;
import interfaces.SpatialEntity;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/*
* environment holds all the objects
*
* */

public class Environment {

    private static ArrayList<SpatialEntity> bodies;
    private static PhysicsHandler simulator;
    private Pane canvas;

    /**
     * Constructs an Environment.
     */
    public Environment() {
        bodies = new ArrayList<SpatialEntity>();
        simulator = new PhysicsHandler();
        this.canvas = new Pane();
    }

    /**
     * Creates a Planet and adds it to the Environment's bodies ArrayList.
     *
     * @return the newly created Planet.
     */
    public static Planet createPlanet() {
        Planet planet = new Planet();
        bodies.add(planet);
        simulator.addBody(planet);

        return planet;
    }

    /**
     * Creates a Star and adds it to the Environment's bodies ArrayList.
     *
     * @return the newly created Star.
     */
    public static Star createStar() {
        Star star = new Star();
        bodies.add(star);
        simulator.addBody(star);

        return star;
    }


    /**
     * Creates a JavaFX Group of all the SpatialEntities Shapes in the bodies list.
     * For the purposes of displaying the shapes on the screen.
     *
     * @return the created Group.
     */
    public Group generateGroupAllBodiesShapes() {
        Group bodyShapes = new Group();
        bodies.forEach(body -> bodyShapes.getChildren().add(body.getShape()));
        return bodyShapes;
    }

    /**
     * Creates objects and adds them to the Bodies ArrayList to be used.
     */
    public void generateBodies() { // todo: this is hardcoded, base it off user input instead?
        createStar();
        createPlanet();
    }

}

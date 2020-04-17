package classes;

import interfaces.SpatialEntity;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Environment {

    private ArrayList<SpatialEntity> bodies;
    private PhysicsHandler simulator;
    private Pane canvas;

    /**
     * Creates a Planet.
     *
     * @return a new Earth.
     */
    public Planet createEarth() { // todo: use specific attributes for an Earth?
        return new Planet();
    }


}

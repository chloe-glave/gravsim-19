package classes;

import interfaces.DynamicBody;
import interfaces.PhysicalBody;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * A class to process and run the physics simulation.
 *
 * @author Kayden Schmidt
 * @version 2020
 */
public class PhysicsHandler {
    /**
     * The default physics tick interval, in milliseconds.
     */
    public static final long DEFAULT_INTERVAL = 20;
    /**
     * The coefficient for gravitational acceleration.
     */
    public static final double GRAVITATIONAL_CONSTANT = 2.0;

    private long interval;
    private ArrayList<DynamicBody> dynamicBodies;
    private ArrayList<PhysicalBody> bodies;
    private boolean collisionsOn;
    private boolean paused;
    private double speed;
    private Thread thread;

    /**
     * Instantiate a PhysicsHandler.
     *
     * @pre bodies must be non-null
     * @pre dynamicBodies must be non-null
     * @post instantiate a PhysicsHandler to handle the bodies provided
     */
    public PhysicsHandler() {
        this.bodies = new ArrayList<>();
        this.dynamicBodies = new ArrayList<>();
        this.interval = DEFAULT_INTERVAL;
        this.speed = 1.0;
        this.collisionsOn = true;
        this.paused = false;
        this.thread = new Thread(this::run);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Pause the simulation.
     *
     * @post pause the simulation
     */
    public void pause() {
        paused = true;
    }

    /**
     * Unpause the simulation.
     *
     * @post unpause the simulation
     */
    public void unPause() {
        paused = false;
    }

    /**
     * Toggle the pausing of the simulation.
     *
     * @post toggle the pausing of the simulation
     */
    public void togglePause() {
        paused = !paused;
    }

    /**
     * Toggle collisions in the simulation.
     *
     * @post toggle collisions in the simulation
     */
    public void toggleCollisions() {
        collisionsOn = !collisionsOn;
    }

    /* Check for collisions between physical bodies, and simulate any found. */
    private void checkCollisions() {
        if (!paused && collisionsOn) {
            for (int i = 0; i < bodies.size() - 1; i++) {
                PhysicalBody first = bodies.get(i);
                for (int j = i + 1; j < bodies.size(); j++) {
                    PhysicalBody second = bodies.get(j);
                    Shape intersection = Shape.intersect(first.getShape(), second.getShape());
                    if (intersection.getBoundsInLocal().getWidth() != -1) {
                        simulateCollision(first, second);
                    }
                }
            }
        }
    }

    /* Simulate a collision between two physical bodies. */
    private void simulateCollision(PhysicalBody first, PhysicalBody second) {
        System.out.println("You hear explosions or something.");
    }

    /* Move all dynamic bodies assigned to this handler, once. */
    private void moveBodies() {
        for (DynamicBody body : dynamicBodies) {
            body.move();
        }
    }

    /* Accelerate all dynamic bodies towards all other bodies, once. */
    private void accelerateBodies() {
        for (DynamicBody body : dynamicBodies) {
            for (PhysicalBody otherBody : bodies) {
                if (body != otherBody) {
                    double deltaX = otherBody.getX() - body.getX();
                    double deltaY = otherBody.getY() - body.getY();
                    double deltaTotal = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                    deltaX /= deltaTotal;
                    deltaY /= deltaTotal;
                    body.addVx(otherBody.getMass() * GRAVITATIONAL_CONSTANT * deltaX);
                    body.addVy(otherBody.getMass() * GRAVITATIONAL_CONSTANT * deltaY);
                }
            }
        }
    }

    /* Start the simulation. */
    private void run() {
        boolean running = true;
        while (running) {
            moveBodies();
            checkCollisions();
            accelerateBodies();

            try {
                Thread.sleep((long) (interval / speed));
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
            }
        }
    }

    /**
     * Set the speed of the simulation.
     *
     * @param speed the new speed for the simulation
     * @pre speed must be positive
     * @post set the speed of the simulation
     */
    public void setSpeed(double speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    /**
     * Adds a body to the ArrayList of bodies being handled.
     *
     * @param body the body to add
     * @pre body must be non-null
     * @post add the provided body to the ArrayList of bodies being handled
     */
    public void addBody(PhysicalBody body) {
        this.bodies.add(body);
    }

    /**
     * Removes a body from the ArrayList of bodies being handled.
     *
     * @param body the body to remove
     * @pre body must be non-null
     * @post remove the provided body from the ArrayList of bodies being handled
     */
    public void removeBody(PhysicalBody body) {
        this.bodies.remove(body);
    }

    /**
     * Adds a dynamic body to the ArrayList of dynamic bodies being handled.
     *
     * @param body the dynamic body to add
     * @pre body must be non-null
     * @post add the provided dynamic body to the ArrayList of dynamic bodies being handled
     */
    public void addDynamicBody(DynamicBody body) {
        this.dynamicBodies.add(body);
    }

    /**
     * Removes a dynamic body from the ArrayList of dynamic bodies being handled.
     *
     * @param body the dynamic body to remove
     * @pre body must be non-null
     * @post remove the provided dynamic body from the ArrayList of dynamic bodies being handled
     */
    public void removeDynamicBody(DynamicBody body) {
        this.dynamicBodies.remove(body);
    }
}

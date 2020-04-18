package classes;

import interfaces.DynamicBody;
import interfaces.PhysicalBody;
import javafx.application.Platform;
import javafx.scene.shape.Shape;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A class to process and run the physics simulation.
 *
 * @author Kayden Schmidt
 * @author Janelle Kwok
 * @author Chloe Glave
 * @author Keegan Maundrell
 *
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
    public static final double GRAVITATIONAL_CONSTANT = 0.2;

    private final long interval;
    private final CopyOnWriteArrayList<DynamicBody> dynamicBodies; // 1/2 TYPES OF COLLECTIONS
    private final CopyOnWriteArrayList<PhysicalBody> bodies;
    private boolean collisionsOn;
    private boolean paused;
    private double speed;
    private final Thread thread;
    private final Environment environment;

    /**
     * Instantiate a PhysicsHandler.
     *
     * @param environment the environment whose physics this is handling
     * @pre bodies must be non-null
     * @pre dynamicBodies must be non-null
     * @post instantiate a PhysicsHandler to handle the bodies provided
     */
    public PhysicsHandler(Environment environment) {
        this.environment = environment;
        this.bodies = new CopyOnWriteArrayList<>();
        this.dynamicBodies = new CopyOnWriteArrayList<>();
        this.interval = DEFAULT_INTERVAL;
        this.speed = 1.0;
        this.collisionsOn = true;
        this.paused = false;
        this.thread = new Thread(this::run);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Pause or unpause the simulation.
     *
     * @param paused the new paused value
     * @post pause or unpause the simulation
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
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
        Platform.runLater(() -> {
            if (first.getMass() >= second.getMass()) {
                removeBody(second);
            } else {
                removeBody(first);
            }
        });
    }

    /* Move all dynamic bodies assigned to this handler, once. */
    private void moveBodies() {
        for (DynamicBody body : dynamicBodies) {
            body.move();
        }
    }

    /* Accelerate all dynamic bodies towards all other bodies, once. */
    private void accelerateBodies() {
        for (DynamicBody body : dynamicBodies) { // USE OF POLYMORPHISM
            for (PhysicalBody otherBody : bodies) {
                if (body != otherBody) {
                    double deltaX = otherBody.getX() - body.getX();
                    double deltaY = otherBody.getY() - body.getY();
                    double deltaTotal = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                    if (deltaTotal < 1) {
                        deltaTotal = 1;
                    }
                    deltaX /= deltaTotal;
                    deltaY /= deltaTotal;
                    body.addVx(otherBody.getMass() * GRAVITATIONAL_CONSTANT
                            / deltaTotal * deltaX);
                    body.addVy(otherBody.getMass() * GRAVITATIONAL_CONSTANT
                            / deltaTotal * deltaY);
                }
            }
        }
    }

    /* Start the simulation. */
    private void run() { // USE OF THREADING
        boolean running = true;
        while (running) {
            moveBodies();
            checkCollisions();
            accelerateBodies();

            try { // EXCEPTION HANDLING
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
        if (body instanceof DynamicBody) {
            this.dynamicBodies.add((DynamicBody) body);
        }
    }

    /**
     * Removes a body from the ArrayList of bodies being handled.
     *
     * @param body the body to remove
     * @pre body must be non-null
     * @post remove the provided body from the ArrayList of bodies being handled
     */
    public void removeBody(PhysicalBody body) {
        environment.removeBody(body);
        this.bodies.remove(body);
        if (body instanceof DynamicBody) {
            this.dynamicBodies.remove(body);
        }
    }

    @Override
    public String toString() {
        return "PhysicsHandler{" +
                "interval=" + interval +
                ", dynamicBodies=" + dynamicBodies +
                ", bodies=" + bodies +
                ", collisionsOn=" + collisionsOn +
                ", paused=" + paused +
                ", speed=" + speed +
                ", thread=" + thread +
                ", environment=" + environment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicsHandler)) return false;
        PhysicsHandler that = (PhysicsHandler) o;
        return interval == that.interval &&
                collisionsOn == that.collisionsOn &&
                paused == that.paused &&
                Double.compare(that.speed, speed) == 0 &&
                Objects.equals(dynamicBodies, that.dynamicBodies) &&
                Objects.equals(bodies, that.bodies) &&
                Objects.equals(thread, that.thread) &&
                Objects.equals(environment, that.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval, dynamicBodies, bodies, collisionsOn, paused, speed, thread, environment);
    }
}

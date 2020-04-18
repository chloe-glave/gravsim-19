package classes;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Detects and manages click behaviour.
 *
 * @author Janelle Kwok
 * @author Chloe Glave
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class ClickHandler implements EventHandler<MouseEvent> {
    private static final double VELOCITY_COEFFICIENT = 40.0;

    private Environment environment;
    private boolean creatingLine;
    private double initialX;
    private double initialY;

    public ClickHandler(Environment environment) {
        super();
        this.environment = environment;
        this.creatingLine = false;
        this.initialX = 0;
        this.initialY = 0.0;
    }

    /**
     * Used to handle mouse-click events.
     *
     * @param mouseEvent The mouseEvent passed in.
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        double clickX = mouseEvent.getX();
        double clickY = mouseEvent.getY();
        if (!creatingLine) {
            this.initialX = clickX;
            this.initialY = clickY;
            creatingLine = true;
        } else {
            creatingLine = false;

            environment.createPlanet((clickX - initialX) / VELOCITY_COEFFICIENT,
                    (clickY - initialY) / VELOCITY_COEFFICIENT, clickX, clickY);
        }
    }

    /**
     * Generate a String representation of the ClickHandler.
     *
     * @return a String representation of the ClickHandler
     */
    @Override
    public String toString() {
        return "ClickHandler{}";
    }
}

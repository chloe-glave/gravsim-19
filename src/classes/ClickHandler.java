package classes;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

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
    private Environment environment;

    public ClickHandler(Environment environment) {
        super();
        this.environment = environment;
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

        environment.createPlanet(clickX, clickY);
    }

    /**
     * Check if two ClickHandlers are equal.
     *
     * @param o the object against which to check
     * @return whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClickHandler that = (ClickHandler) o;
        return environment.equals(that.environment);
    }

    /**
     * Create a hashcode for the ClickHandler.
     *
     * @return a hashcode for the ClickHandler
     */
    @Override
    public int hashCode() {
        return Objects.hash(environment);
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

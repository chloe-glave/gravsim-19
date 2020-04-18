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
    private Environment environment;

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

        environment.createPlanet(clickX, clickY);
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

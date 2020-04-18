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

    /**
     * Used to handle mouse-click events.
     *
     * @param mouseEvent The mouseEvent passed in.
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        double clickX = mouseEvent.getX();
        double clickY = mouseEvent.getY();

        System.out.println("mouse click detected! " + clickX + " " + clickY);
    }

}

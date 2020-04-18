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
     * Detects the X and Y coordinates of a click in the window.
     *
     * @param mouseEvent the mouse click.
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        double clickX = mouseEvent.getX();
        double clickY = mouseEvent.getY();

        System.out.println("mouse click detected! " + clickX + " " + clickY);
    }

}

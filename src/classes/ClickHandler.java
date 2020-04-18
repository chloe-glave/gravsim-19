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

    @Override
    public void handle(MouseEvent mouseEvent) { // todo: @Kayden add whatever click stuff u want
        double clickX = mouseEvent.getX();
        double clickY = mouseEvent.getY();

        System.out.println("mouse click detected! " + clickX + " " + clickY);
    }

}

package classes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Overlay {
    private Group hudGroup;

    public void createHUD() {
        Rectangle rectangle1 = new Rectangle(0, 700);
        rectangle1.setFill(Color.GRAY);
        hudGroup = new Group(rectangle1);
    }

    public Group getHudGroup() {
        return hudGroup;
    }
}

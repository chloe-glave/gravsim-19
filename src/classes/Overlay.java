package classes;

import classes.driver.Driver;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Overlay {
    private Group hudGroup;
    public static final int RECTANGLE_BASE_Y = 640;
    public static final int RECTANGLE_BASE_HEIGHT = Driver.WINDOW_HEIGHT - RECTANGLE_BASE_Y;
    public static final double RECTANGLE_BASE_X = 7.5;


    public void createHUD() {
        Rectangle rectangleBase = new Rectangle(0, RECTANGLE_BASE_Y, Driver.WINDOW_WIDTH,
                RECTANGLE_BASE_HEIGHT);
        rectangleBase.setFill(Color.GRAY);
        Rectangle rectangleFill = new Rectangle(7.5, 647.5, Driver.WINDOW_WIDTH - 14.5,
                Driver.WINDOW_HEIGHT - 655);
        rectangleFill.setFill(Color.LIGHTGRAY);

        hudGroup = new Group(rectangleBase, rectangleFill);
    }

    public Group getHudGroup() {
        return hudGroup;
    }
}

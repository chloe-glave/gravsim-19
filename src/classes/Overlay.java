package classes;

import classes.driver.Driver;
import classes.Environment;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Overlay {
    public static final int RECTANGLE_BASE_Y = 640;
    public static final int RECTANGLE_BASE_HEIGHT = Driver.WINDOW_HEIGHT - RECTANGLE_BASE_Y;
    public static final double RECTANGLE_FILL_X = 7.5;
    public static final double RECTANGLE_FILL_Y = 647.5;
    public static final double RECTANGLE_FILL_HEIGHT = Driver.WINDOW_HEIGHT - 655;

    private Group hudGroup;
    private static Button spawnButtonPlanet;
    private static Button spawnButtonStar;

    public void createHUD() {
        Rectangle rectangleBase = new Rectangle(0, RECTANGLE_BASE_Y, Driver.WINDOW_WIDTH,
                RECTANGLE_BASE_HEIGHT);
        rectangleBase.setFill(Color.GRAY);

        Rectangle rectangleFill = new Rectangle(RECTANGLE_FILL_X, RECTANGLE_FILL_Y,
                Driver.WINDOW_WIDTH - RECTANGLE_FILL_X * 2, RECTANGLE_FILL_HEIGHT);
        rectangleFill.setFill(Color.LIGHTGRAY);

        spawnButtonPlanet = new Button("Spawn Planet");
        spawnButtonPlanet.setMaxSize(100, 150);
        spawnButtonPlanet.setTranslateX(350.0);
        spawnButtonPlanet.setTranslateY(665.75);
        spawnButtonPlanet.setOnAction(click -> {
            Environment.createPlanet();
        });

        spawnButtonStar = new Button("Spawn Star");
        spawnButtonStar.setMaxSize(100, 150);
        spawnButtonStar.setTranslateX(600.0);
        spawnButtonStar.setTranslateY(665.75);
        spawnButtonStar.setOnAction(click -> {
            Environment.createStar();
        });

        hudGroup = new Group(rectangleBase, rectangleFill, spawnButtonPlanet, spawnButtonStar);
    }

    public Group getHudGroup() {
        return hudGroup;
    }
}

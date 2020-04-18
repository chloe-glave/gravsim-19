package classes;

import classes.driver.Driver;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * User-interface for the bottom portion of the screen - contains interactable buttons.
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Overlay {
    private static final int RECTANGLE_BASE_Y = 640;
    private static final int RECTANGLE_BASE_HEIGHT = Driver.WINDOW_HEIGHT - RECTANGLE_BASE_Y;
    private static final double RECTANGLE_FILL_X = 7.5;
    private static final double RECTANGLE_FILL_Y = 647.5;
    private static final double RECTANGLE_FILL_HEIGHT = Driver.WINDOW_HEIGHT - 655;

    private Group hudGroup;
    private Button spawnButtonPlanet;
    private Button spawnButtonStar;

    /**
     * Accesses the getSpawnButtonPlanet Button.
     *
     * @return getSpawnButtonPlanet.
     */
    public Button getSpawnButtonPlanet() {
        return spawnButtonPlanet;
    }

    /**
     * Accesses the getSpawnButtonStar Button.
     *
     * @return getSpawnButtonStar.
     */
    public Button getSpawnButtonStar() {
        return spawnButtonStar;
    }

    /**
     * Accesses the hudGroup Group of JavaFX elements.
     *
     * @return hudGroup.
     */
    public Group getHudGroup() {
        return hudGroup;
    }

    /**
     * Creates the overlay HUD window to display at the bottom of the screen and hold Buttons.
     */
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

        spawnButtonStar = new Button("Spawn Star");
        spawnButtonStar.setMaxSize(100, 150);
        spawnButtonStar.setTranslateX(600.0);
        spawnButtonStar.setTranslateY(665.75);

        hudGroup = new Group(rectangleBase, rectangleFill, spawnButtonPlanet, spawnButtonStar);
    }

}

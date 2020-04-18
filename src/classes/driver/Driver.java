package classes.driver;

import classes.Environment;
import classes.Overlay;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * Drives the JavaFX program and displays the content in the window.
 *
 * @author Chloe Glave
 * @author Janelle Kwok
 * @author Kayden Schmidt
 * @author Keegan Maundrell
 *
 * @version 2020
 */
public class Driver extends Application {

    /**
     * The width of the JavaFX window.
     */
    public static final int WINDOW_WIDTH = 1080;

    /**
     * The height of the JavaFX window.
     */
    public static final int WINDOW_HEIGHT = 720;

    /**
     * The background color of the JavaFX window.
     */
    static final Color WINDOW_BACKGROUND_COLOR = Color.BLACK;

    private Environment environment = new Environment();

    private Overlay overlay = new Overlay();

    private Group backgroundDecorations = BackgroundStar.generateStars();

    /**
     * Displays the scene in the window.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {

        overlay.createHUD();

        overlay.getSpawnButtonPlanet().setOnAction(click -> environment.createPlanet());

        overlay.getSpawnButtonStar().setOnAction(click -> environment.createStar());

        environment.generateCoins();

        Group root = new Group(backgroundDecorations, environment.getBodyShapes(),
                overlay.getHudGroup());

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_BACKGROUND_COLOR);

        primaryStage.setTitle("The beginning of something great");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

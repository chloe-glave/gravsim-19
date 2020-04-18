package classes.driver;

import classes.Environment;
import classes.Overlay;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

/**
 * Drives the JavaFX program and displays the content in the window.
 *
 * @author Chloe Glave
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

    private Environment environment;

    private Overlay overlay;

    private Group backgroundDecorations;

    /**
     * Instantiates variables and starts up event handlers.
     */
    private void setUp() {
        environment = new Environment();
        overlay = new Overlay();
        backgroundDecorations = BackgroundStar.generateStars();

        overlay.createHUD();
        overlay.getSpawnButtonPlanet().setOnAction(click -> environment.createPlanet());
        overlay.getSpawnButtonStar().setOnAction(click -> environment.createStar());

        environment.generateCoins();
    }

    /**
     * Displays the scene in the window.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {

        setUp();

        Group root = new Group(backgroundDecorations, environment.getBodyShapes(),
                overlay.getHudGroup());

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_BACKGROUND_COLOR);

        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> System.out.println("mouse click detected! " + mouseEvent.getX() + " " + mouseEvent.getY()));

        primaryStage.setTitle("GRAVSIM-19");
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

package classes.driver;

import classes.Star;
import javafx.application.Application;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * Drives the JavaFX program.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver extends Application {

    /**
     * The width of the JavaFX window.
     */
    final static int WINDOW_WIDTH = 1080;

    /**
     * The height of the JavaFX window.
     */
    final static int WINDOW_HEIGHT = 720;

    /**
     * The background color of the JavaFX window.
     */
    final static Color WINDOW_BACKGROUND_COLOR = Color.BLACK;

    /**
     * Displays the scene in the window.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {

        Group backgroundDecorations = BackgroundStar.generateStars();

        Star star = new Star();

        Shape starShape = star.getShape();

        Group root = new Group(starShape, backgroundDecorations);

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
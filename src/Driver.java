import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Driver extends Application {

    /**
     * Drives the JavaFX program.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {

        Circle circle = new Circle(200, 200, 200); // placeholder

        Group root = new Group(circle);

        Scene scene = new Scene(root, 500, 500, Color.LAVENDER);

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

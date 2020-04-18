package classes.driver;

import classes.ClickHandler;
import classes.Environment;
import classes.Overlay;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

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

    /*
     * The background color of the JavaFX window.
     */
    private static final Color WINDOW_BACKGROUND_COLOR = Color.BLACK;

    private Environment environment;

    private Overlay overlay;

    private Group backgroundDecorations;

    private ClickHandler clickHandler;

    private Text leftText;

    private Text rightText;

    private static Text scoreText;

    /*
     * Instantiates variables and starts up event handlers.
     */
    private void setUp() {
        environment = new Environment();
        overlay = new Overlay();
        backgroundDecorations = BackgroundStar.generateStars();
        clickHandler = new ClickHandler();

        leftText = new Text();
        rightText = new Text();
        scoreText = new Text();

        overlay.createHUD();
        overlay.getSpawnButtonPlanet().setOnAction(click -> environment.createPlanet());
        overlay.getSpawnButtonStar().setOnAction(click -> environment.createStar());

        environment.generateCoins();
    }

    /*
     * Creates tutorial text for first time users to help them understand playing the game.
     */
    private Group createTutorialText() {
        leftText.setText("Gravity Simulator");
        leftText.setX(80.0);
        leftText.setY(690.0);
        leftText.setFont(Font.font(24.0));

        rightText.setText("Create Stars with Planets to orbit them!" +
                "\nTry to collect all the coins using your planets!");
        rightText.setX(730.0);
        rightText.setY(670.0);
        rightText.setFont(Font.font(16.0));

        scoreText.setText("Score: 0");
        scoreText.setX(490.0);
        scoreText.setY(690.0);
        scoreText.setFont(Font.font(24.0));

        return new Group(leftText, rightText, scoreText);

    }

    /**
     * Mutates value of the scoreText on the screen.
     *
     * @param newValue the value to update the score to.
     */
    public static void updateScoreText(int newValue) {
        scoreText.setText("Score: " + newValue);
    }

    /**
     * Displays the scene in the window.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {

        setUp();

        Group root = new Group(backgroundDecorations, environment.getBodyShapes(),
                overlay.getHudGroup(), createTutorialText());

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_BACKGROUND_COLOR);

        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, clickHandler);

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

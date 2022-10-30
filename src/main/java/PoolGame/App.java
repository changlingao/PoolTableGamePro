package PoolGame;

import PoolGame.config.BallReaderFactory;
import PoolGame.config.Reader;
import PoolGame.config.ReaderFactory;
import PoolGame.config.TableReaderFactory;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

/** Main application entry point. */
public class App extends Application {
    private static Stage stage;

    /**
     * @param args First argument is the path to the config file
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /**
     * Starts the application.
     *
     * @param primaryStage The primary stage for the application.
     */
    public void start(Stage primaryStage) {
        stage = primaryStage;
        // choose level scene
        initialScene();
    }

    /**
     * welcome and choose difficulty level
     */
    public static void initialScene() {
        Scene scene = levelChoose();
        stage.setTitle("Pool Table Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The scene to choose level,
     * also handle scene transition when button is clicked.

     * @return the scene to choose level
     */
    private static Scene levelChoose() {
        //      * @param primaryStage the stage of this app
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 600, 400);

        Label welcome = new Label("Welcome! \nchoose difficulty level");
        Button easy = new Button("easy");
        Button normal = new Button("normal");
        Button hard = new Button("hard");
        vBox.getChildren().addAll(welcome, easy, normal, hard);

        // UI style
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        welcome.setFont(new Font(30));
        welcome.setTextAlignment(TextAlignment.CENTER);

        // on click change scene to actual game
        easy.setOnAction(e -> {
            String configPath = "src/main/resources/config_easy.json";
            stage.setScene(gameScene(configPath));
        });
        normal.setOnAction(e -> {
            String configPath = "src/main/resources/config_normal.json";
            stage.setScene(gameScene(configPath));
        });
        hard.setOnAction(e -> {
            String configPath = "src/main/resources/config_hard.json";
            stage.setScene(gameScene(configPath));
        });

        // only return once for level choose scene
        return scene;
    }

    /**
     * parse config file, display the game
     * @param configPath path for config json
     * @return game scene
     */
    private static Scene gameScene(String configPath) {
        GameManager gameManager = new GameManager();

        ReaderFactory tableFactory = new TableReaderFactory();
        Reader tableReader = tableFactory.buildReader();
        tableReader.parse(configPath, gameManager);

        ReaderFactory ballFactory = new BallReaderFactory();
        Reader ballReader = ballFactory.buildReader();
        ballReader.parse(configPath, gameManager);

        gameManager.buildManager();
        gameManager.run();
        return gameManager.getScene();
    }

    /**
     * Checks if the config file path is given as an argument.
     * 
     * @param args
     * @return config path.
     */
    private static String checkConfig(List<String> args) {
        String configPath;
        if (args.size() > 0) {
            configPath = args.get(0);
        } else {
            configPath = "src/main/resources/config_easy.json";
        }
        return configPath;
    }
}

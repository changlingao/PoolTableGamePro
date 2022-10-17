package PoolGame;

import PoolGame.config.*;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/** Main application entry point. */
public class App extends Application {
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
        // choose level scene
        Scene scene = levelChoose(primaryStage);
        primaryStage.setTitle("Pool Table Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The scene to choose level,
     * also handle scene transition when button is clicked.
     * @param primaryStage the stage of this app
     * @return the scene to choose level
     */
    public Scene levelChoose(Stage primaryStage) {
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
            primaryStage.setScene(gameScene(configPath));
        });
        normal.setOnAction(e -> {
            String configPath = "src/main/resources/config_normal.json";
            primaryStage.setScene(gameScene(configPath));
        });
        hard.setOnAction(e -> {
            String configPath = "src/main/resources/config_hard.json";
            primaryStage.setScene(gameScene(configPath));
        });

        // only return once for level choose scene
        return scene;
    }

    /**
     * parse config file, display the game
     * @param configPath path for config json
     * @return game scene
     */
    public Scene gameScene(String configPath) {
        // READ IN CONFIG
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

    // TODO: args ???
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

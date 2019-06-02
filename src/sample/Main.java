package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameScene root = new GameScene(WIDTH,HEIGHT);
        primaryStage.setTitle("Pacman Game");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

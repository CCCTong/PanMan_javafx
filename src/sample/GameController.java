package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {
    public static boolean isWin = false;
    public static boolean isLose = false;
    public static boolean gameStart = false;

    public static void setGameStart(){
        gameStart = true;
    }
    public static void setIsLose(){
        GameScene.startButton.setText("Play like CXK!");
        isLose = true;
    }
    public static void setIsWin(){
        GameScene.winLogo.setVisible(true);
        isWin = true;
    }
}

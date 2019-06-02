package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameScene extends Parent {

    private int width,height;
    private final int TOP = 72,LEFT = 53,RIGHT = 420,BUTTON = 429;
    private boolean dotCanInit = true;
    private Rectangle backGround;
    private ImageView gameMap;
    private ImageView gameLogo;
    private PacMan pacMan;
    private Monster green,pink,oringe,red;
    public static Text startButton;
    private Text showScore;
    private Text showLeft;
    private MediaPlayer bgm;
    public static Text score;
    public static Text left;
    public static ImageView winLogo;

    public GameScene(int width,int height) throws Exception {
        this.width = width;
        this.height = height;
        initGameObject();
        InitBGM();
    }
    private void initGameObject(){
        InitBackGround();
        InitGameLogo();
        InitGameMap();
        InitPacMan();
        MapData.InitBorder();
        InitPacdot();
        InitMonster();
        InitInformation();
    }
    private void InitBGM(){
        //String s = new File("Resources/Bgm.mp3").toString();
        //bgm = new MediaPlayer(new Media(s));
        //bgm.play();
    }
    private void InitInformation(){
        startButton = new Text("Press Start");
        startButton.setFont(Font.font ("Verdana", 30));
       // startButton.setFont(Font.loadFont("Resources/res.ttf",20));
        startButton.setLayoutX(500);
        startButton.setLayoutY(300);
        startButton.setOnMouseClicked(event -> {GameController.setGameStart();});
        startButton.setFill(Color.WHITE);
        getChildren().add(startButton);

        score = new Text(String.valueOf(MapData.Score));
        score.setLayoutX(650);
        score.setLayoutY(360);
        score.setFill(Color.WHITE);
        score.setFont(Font.font ("Verdana", 30));
        getChildren().add(score);

        left = new Text(String.valueOf(MapData.leftDot));
        left.setFill(Color.WHITE);
        left.setFont(Font.font ("Verdana", 30));
        left.setLayoutY(420);
        left.setLayoutX(620);
        getChildren().add(left);

        showScore = new Text("Score : ");
        showScore.setFill(Color.WHITE);
        showScore.setLayoutX(500);
        showScore.setLayoutY(360);
        showScore.setFont(Font.font ("Verdana", 30));
        getChildren().add(showScore);

        showLeft = new Text("Left : ");
        showLeft.setFill(Color.WHITE);
        showLeft.setLayoutX(500);
        showLeft.setLayoutY(420);
        showLeft.setFont(Font.font ("Verdana", 30));
        getChildren().add(showLeft);
    }
    private void InitMonster(){
        MapData.monster = new ArrayList<GameObject>();
        green = new Monster("Resources/Inky.png",222,215);
        pink = new Monster("Resources/Pinky.png",222,215);
        red = new Monster("Resources/Blinky.png",222,215);
        oringe = new Monster("Resources/Clyde.png",222,215);
        MapData.monster.add(green);
        MapData.monster.add(pink);
        MapData.monster.add(red);
        MapData.monster.add(oringe);
        getChildren().add(pink);
        getChildren().add(red);
        getChildren().add(oringe);
        getChildren().add(green);
    }
    private void InitPacMan(){
        pacMan = new PacMan();
        pacMan.setOnKeyPressed(event -> {
            try{
                pacMan.onKeyPressed(event);
            }catch (Exception e){

            }
        });
        pacMan.setFocusTraversable(true);
        pacMan.requestFocus();
        getChildren().add(pacMan);
    }
    private void InitBackGround(){
        backGround = new Rectangle();
        backGround.setFill(Color.BLACK);
        backGround.setWidth(Main.WIDTH);
        backGround.setHeight(Main.HEIGHT);
        getChildren().add(backGround);
    }
    private void InitGameLogo(){
        gameLogo = new ImageView(new Image("Resources/logo.png"));
        gameLogo.setX(450);
        gameLogo.setY(50);
        gameLogo.setFitWidth(320);
        gameLogo.setFitHeight(150);
        getChildren().add(gameLogo);

        GameScene.winLogo = new ImageView(new Image("Resources/Win.PNG"));
        winLogo.setX(450);
        winLogo.setY(150);
        winLogo.setFitHeight(320);
        winLogo.setFitHeight(150);
        winLogo.setVisible(false);
        getChildren().add(winLogo);
    }
    private void InitGameMap(){
        gameMap = new ImageView(new Image("Resources/Maze.png"));
        gameMap.setX(30);
        gameMap.setY(50);
        gameMap.setFitHeight(400);
        gameMap.setFitWidth(400);
        getChildren().add(gameMap);
    }
    public void InitPacdot(){
        MapData.pacDot = new ArrayList<GameObject>();
        for(double x = LEFT; x <= RIGHT; x += 23.6){
            for(double y = TOP; y <= BUTTON; y += 23.6){
                dotCanInit = true;
                PacDot pd = new PacDot(x,y);
                for(GameObject now : MapData.border){
                    if (pd.isCollisionWith(now)) {
                        dotCanInit = false;
                        break;
                    }
                }
                if (dotCanInit) {
                    MapData.pacDot.add(pd);
                    MapData.leftDot++;
                    getChildren().add(pd);
                }
            }
        }
    }
}

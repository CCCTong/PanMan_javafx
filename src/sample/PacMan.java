package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.awt.*;
import java.util.Map;


public class PacMan extends GameObject{

    private ImageView image;
    private Direction direction = Direction.left;
    private final double speed = 7.5;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private int tag = 0;

    public PacMan(){
        image = new ImageView(new Image("Resources/Pacman.png"));
        image.setFitWidth(19);
        image.setFitHeight(19);
        image.setViewport(new Rectangle2D(0,0,16,16));
        image.translateXProperty().bindBidirectional(xProperty());
        image.translateYProperty().bindBidirectional(yProperty());
        setWidth(19);
        setHeight(19);
        getChildren().add(image);
        setX(394);
        setY(394);
        InitTimeline();
    }
    public void onKeyPressed(KeyEvent event) throws Exception{
        if (GameController.isLose || GameController.isWin) return;
        if (!GameController.gameStart) return;
        if (event.getCode() == KeyCode.LEFT){
            UpdatePacManStatus(Direction.left,1,-1);
        }else if (event.getCode() == KeyCode.RIGHT){
            UpdatePacManStatus(Direction.right,1,1);
        }else if (event.getCode() == KeyCode.UP){
            UpdatePacManStatus(Direction.up,0,-1);
        }else if (event.getCode() == KeyCode.DOWN) {
            UpdatePacManStatus(Direction.down,0,1);
        }
        CheckEatDot();
    }
    private void UpdatePacManStatus(Direction dir,int tag,int flag) throws Exception{
        if (direction != dir)
            ChangeImage(dir);
        direction = dir;
        if (tag == 1){
            for(int i=1; i<=speed; i++) {
                moveX(flag);
                if (CheckCollision()) moveX(-flag);
            }
        }else{
            for(int i=1; i<=speed; i++) {
                moveY(flag);
                if (CheckCollision()) moveY(-flag);
            }
        }
    }
    private void ChangeImage(Direction direction){
        if (direction == Direction.up){
            image.setViewport(new Rectangle2D(16,32,16,16));
        }else if (direction == Direction.down){
            image.setViewport(new Rectangle2D(16,48,16,16));
        }else if (direction == Direction.left){
            image.setViewport(new Rectangle2D(16,16,16,16));
        }else if (direction == Direction.right){
            image.setViewport(new Rectangle2D(16,0,16,16));
        }
    }
    private void InitTimeline(){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        keyFrame = new KeyFrame(Duration.millis(100),event -> {
            tag = (tag + 1) % 3;
            if (tag == 0){
                image.setViewport(new Rectangle2D(0,image.getViewport().getMinY(),16,16));
            }else if (tag == 1){
                image.setViewport(new Rectangle2D(16,image.getViewport().getMinY(),16,16));
            }else {
                image.setViewport(new Rectangle2D(32,image.getViewport().getMinY(),16,16));
            }
            CheckMeetMonster();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    private boolean CheckCollision(){
        for(GameObject border : MapData.border)
            if (isCollisionWith(border)) {
                return true;
            }
        return false;
    }
    private void CheckEatDot(){
        for(GameObject dot : MapData.pacDot){
            if (isCollisionWith(dot) && dot.isVisible()){
                dot.setVisible(false);
                MapData.leftDot--;
                if (MapData.leftDot == 0) GameController.setIsWin();
                MapData.Score++;
                GameScene.score.setText(String.valueOf(MapData.Score*100));
                GameScene.left.setText(String.valueOf(MapData.leftDot));
            }
        }
    }
    private void CheckMeetMonster(){
        for(GameObject monster : MapData.monster){
            if (isCollisionWith(monster)){
                 GameController.setIsLose();
                 return;
            }
        }
    }
}

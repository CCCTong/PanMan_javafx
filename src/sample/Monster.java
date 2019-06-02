package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.Map;

public class Monster extends GameObject {
    private double speed = 2;
    private Direction direction = Direction.up;
    private KeyFrame keyFrame;
    private Timeline timeline;
    private ImageView image;
    private int tag = -1;
    private int AnimationTag = 0;
    private int currFrame = 0;

    public Monster(String s,int x,int y){
        image = new ImageView(new Image(s));
        image.translateXProperty().bindBidirectional(xProperty());
        image.translateYProperty().bindBidirectional(yProperty());
        image.setFitHeight(20);
        image.setFitHeight(20);
        image.setViewport(new Rectangle2D(0,0,16,16));
        setWidth(20);
        setHeight(20);
        getChildren().addAll(image);
        setX(x);
        setY(y);
        InitTimeline();
    }
    private void InitTimeline(){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        keyFrame = new KeyFrame(Duration.millis(20),event -> {
            if (GameController.isLose || GameController.isWin) return;
            if (!GameController.gameStart) return;
            if (direction == Direction.up){
                Move(0,-1);
            }else if (direction == Direction.down){
                Move(0,1);
            }else if (direction == Direction.left){
                Move(1,-1);
            }else if (direction == Direction.right){
                Move(1,1);
            }
            currFrame++;
            if (currFrame == 20){
                FootAnimation();
                currFrame = 0;
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    private void Move(int tag,int flag){
        for(int i=0; i<speed; i++){
            if (tag == 1) {
                moveX(flag);
                if (CheckCollision()){
                    moveX(-flag); setNexDirection();
                }
            }else{
                moveY(flag);
                if (CheckCollision()){
                    moveY(-flag); setNexDirection();
                }
            }
        }
    }
    private boolean CheckCollision(){
        for(GameObject border : MapData.border)
            if (isCollisionWith(border)) {
                return true;
            }
        return false;
    }
    private void setNexDirection(){
        if (tag == -1) {
            tag = ((int)Math.random()*100) % 2;
            if (tag == 0) direction = Direction.left;
            else direction = Direction.right;
            ChangeImage(direction);
            return;
        }
        tag = (int)((Math.random()*1000) % 4);
        if (tag == 0 && direction != Direction.left) direction = Direction.right;
        else if (tag == 1 && direction != Direction.up) direction = Direction.down;
        else if (tag == 2 && direction != Direction.right) direction = Direction.left;
        else if (tag == 3 && direction != Direction.down) direction = Direction.up;
        ChangeImage(direction);
    }
    private void ChangeImage(Direction direction){
        if (direction == Direction.up){
            image.setViewport(new Rectangle2D(0,32,16,16));
        }else if (direction == Direction.down){
            image.setViewport(new Rectangle2D(0,48,16,16));
        }else if (direction == Direction.left){
            image.setViewport(new Rectangle2D(0,16,16,16));
        }else if (direction == Direction.right){
            image.setViewport(new Rectangle2D(0,0,16,16));
        }
    }
    private void FootAnimation(){
        AnimationTag ^= 1;
        if (AnimationTag == 0){
            image.setViewport(new Rectangle2D(0,image.getViewport().getMinY(),16,16));
        }else{
            image.setViewport(new Rectangle2D(16,image.getViewport().getMinY(),16,16));
        }
    }
}

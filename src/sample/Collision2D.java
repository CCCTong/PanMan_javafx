package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Collision2D extends GameObject{

    private Rectangle bolder;

    public Collision2D(double x,double y,double width,double height){
        bolder = new Rectangle(x,y,width,height);
        bolder.translateXProperty().bindBidirectional(xProperty());
        bolder.translateYProperty().bindBidirectional(yProperty());
        bolder.setFill(Color.YELLOW);

    }
}

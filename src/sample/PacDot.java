package sample;

import javafx.scene.shape.Rectangle;
import javafx.scene.image.*;

public class PacDot extends GameObject{
    ImageView image;
    public PacDot(double x,double y){
        image = new ImageView(new Image("Resources/Pacdot.png"));
        image.setFitWidth(3);
        image.setFitHeight(3);
        image.translateXProperty().bindBidirectional(xProperty());
        image.translateYProperty().bindBidirectional(yProperty());
        setX(x);
        setY(y);
        getChildren().add(image);
    }
}

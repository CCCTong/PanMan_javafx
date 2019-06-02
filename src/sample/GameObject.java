package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;

public class GameObject extends Parent {
    protected DoubleProperty widthProperty = new SimpleDoubleProperty(0);
    protected DoubleProperty heightProperty = new SimpleDoubleProperty(0);
    protected DoubleProperty xProperty = new SimpleDoubleProperty(0);
    protected DoubleProperty yProperty = new SimpleDoubleProperty(0);

    public  DoubleProperty widthProperty() {
        return  widthProperty;
    }
    public double getWidth(){
        return widthProperty.get();
    }
    public void setWidth(double width){
        this.widthProperty.set(width);
    }
    public  DoubleProperty heightProperty() {
        return  heightProperty;
    }
    public double getHeight(){
        return heightProperty.get();
    }
    public void setHeight(double height){
        this.heightProperty.set(height);
    }
    public  DoubleProperty xProperty() {
        return  xProperty;
    }
    public double getX(){
        return xProperty.get();
    }
    public void setX(double x){
        this.xProperty.set(x);
    }
    public  DoubleProperty yProperty() {
        return yProperty;
    }
    public double getY(){
        return yProperty.get();
    }
    public void setY(double y){
        this.yProperty.set(y);
    }
    public void moveX(double x){
        this.xProperty.set(getX() + x);
    }
    public void moveY(double y){
        this.yProperty.set(getY() + y);
    }
    public boolean isCollisionWith(GameObject gameObject){
        if(getX() + getWidth() > gameObject.getX() && getX() < gameObject.getX() + gameObject.getWidth() && getY() + getHeight() > gameObject.getY() && getY() < gameObject.getY() + gameObject.getHeight()){
            return true;
        }
        return false;
    }
}

package stickman.model.entity;


import java.util.ArrayList;
import java.util.List;

public abstract class MovableEntity implements Entity {
    List<String> ImagePaths = new ArrayList<String>();


    double XPos;

    double YPos;
    double height;
    double width;
    double xVel;
    double yVel;
    Layer layer;
    public MovableEntity(double x, double y, double height,double width){
        XPos = x;
        YPos = y;
        this.height = height;
        this.width = width;
        xVel = 0.0;
        yVel = 0.0;
    }

    @Override
    public double getXPos() {
        return XPos;
    }

    @Override
    public double getYPos() { return YPos; }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public Layer getLayer() {
        return layer;
    }
    public List<String> getPaths(){ return ImagePaths;}
    public void setYPos(double YPos) {
        this.YPos = YPos;
    }
    public void setXPos(double XPos){
        this.XPos = XPos;
    }
    public void setxVel(double xVel){
        this.xVel = xVel;
    }
    public void setyVel(double yVel){
        this.yVel = yVel;
    }
    public double getyVel(){
        return yVel;
    }
    public double getxVel(){
        return xVel;
    }
    public void tick(){
        setXPos(getxVel()+getXPos());
        setYPos(getyVel()+getYPos());
    }
}

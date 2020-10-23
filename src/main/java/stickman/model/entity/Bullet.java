package stickman.model.entity;

import java.util.List;

public class Bullet extends MovableEntity{
    //"Left ot Right"
    String direction;
    public Bullet(double x, double y, double height, double width, String direction) {
        super(x, y, height, width);
        ImagePaths.add("bullet1.png");
        ImagePaths.add("bullet2.png");
        layer = Layer.FOREGROUND;
        this.direction = direction;
        System.out.println(direction);
        if(direction.equals("Right")){
            setxVel(3);
        }else{
            setxVel(-3);
        }
    }



    @Override
    public String getImagePath() {
        if(direction.equals("Right")){
            return ImagePaths.get(0);
        }else{
            return ImagePaths.get(1);
        }
    }
}

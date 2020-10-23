package stickman.model.entity;

import stickman.model.state.EnermyState;
import stickman.model.state.EnermyStateBlue;
import stickman.model.state.EnermyStateGreen;

public class EnermyEntity extends MovableEntity{
    EnermyState state;
    int type;
    public EnermyEntity(double x, double y, double height, double width, int type) {
        super(x, y, height, width);
        this.type = type;
        ImagePaths.add("slimeBa.png");
        ImagePaths.add("slimeBb.png");
        ImagePaths.add("slimeGa.png");
        ImagePaths.add("slimeGb.png");
        ImagePaths.add("slimePa.png");
        ImagePaths.add("slimePb.png");
        ImagePaths.add("slimeRa.png");
        ImagePaths.add("slimeRb.png");
        ImagePaths.add("slimeYa.png");
        ImagePaths.add("slimeYb.png");
        setState();
        layer = Layer.FOREGROUND;
    }
    private void setState(){
        if(type == 1) {
            state = new EnermyStateBlue(this);
        }else if(type == 2){
            state = new EnermyStateGreen(this);
        }
    }
    @Override
    public String getImagePath() {
        return state.getImagePath();
    }
    public void tick(){
        state.think();
        setXPos(getxVel()+getXPos());
        setYPos(getyVel()+getYPos());
    }
}

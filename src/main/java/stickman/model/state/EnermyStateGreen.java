package stickman.model.state;

import stickman.model.entity.MovableEntity;

public class EnermyStateGreen implements EnermyState{
    MovableEntity m;
    int count;
    public EnermyStateGreen(MovableEntity m){
        this.m = m;
        count = 0;
    }
    @Override
    public void think() {
        //go left for 150 tick, stay for 50 tick, to right for 150 tick
        if(count%350 > 200) {
            m.setxVel(1.0);
        }else if(count%350 < 150){
            m.setxVel(-1.0);
        }else{
            m.setxVel(0);
        }
        count++;
    }

    @Override
    public String getImagePath() {
        // change image each 10 tick
        if(count%20 < 10) {
            return m.getPaths().get(2);
        }else{
            return m.getPaths().get(3);
        }
    }

}

package stickman.model.state;

import stickman.model.entity.MovableEntity;

public class EnermyStateBlue implements EnermyState{
    MovableEntity m;
    int count;
    public EnermyStateBlue(MovableEntity m){
        this.m = m;
        count = 0;
    }
    @Override
    public void think() {
        //go left for 150 tick, go right for 150 tick
        if(count%300 > 149) {
            m.setxVel(-1.0);
        }else{
            m.setxVel(1.0);
        }
        count++;
    }

    @Override
    public String getImagePath() {
        // change image each 10 tick
        if(count%20 < 10) {
            return m.getPaths().get(0);
        }else{
            return m.getPaths().get(1);
        }
    }
}

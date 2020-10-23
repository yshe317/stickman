package stickman.model.entity;

import stickman.model.Strategy.*;
import java.util.List;

public class Hero extends MovableEntity {
    int life;
    private int time;
    private int timecount;
    boolean isStand;
    HeroAttackStratgy stratgy;
//    HeroState sky;
    String direction;
    public Hero(double x, double y, double height, double width) {
        super(x, y, height, width);
        life = 3;
        isStand = false;
//        state = new OnGroundState(this);
//        ground = state;
//        sky = new InSkyState(this, state.getDirection());
        ImagePaths.add("ch_stand1.png");
        ImagePaths.add("ch_stand2.png");
        ImagePaths.add("ch_stand3.png");
        ImagePaths.add("ch_stand4.png");
        ImagePaths.add("ch_stand5.png");
        ImagePaths.add("ch_stand6.png");
        ImagePaths.add("ch_walk1.png");
        ImagePaths.add("ch_walk2.png");
        ImagePaths.add("ch_walk3.png");
        ImagePaths.add("ch_walk4.png");
        ImagePaths.add("ch_walk5.png");
        ImagePaths.add("ch_walk6.png");
        ImagePaths.add("ch_walk7.png");
        ImagePaths.add("ch_walk8.png");
        direction = "Right";
        stratgy = new NonMushroomed();
        layer = Layer.FOREGROUND;
        time = 0;
        timecount = 0;
    }


    public boolean setStratgy(){
        if(!stratgy.attack()){stratgy = new Mushroomed(); return true;}
        return false;
    }

    @Override
    public String getImagePath() {
        //change image each 20 tick
        timecount ++;
        if(timecount%20 == 0){
            time++;
        }

        if(this.getxVel() > 0) {
            //go right
            // 6 -9
            direction = "Right";
            return this.getPaths().get(6+time%4);
        }else if(this.getxVel() < 0) {
            //go left
            // 10-13
            direction = "Left";
            return this.getPaths().get(10 + time%4);

        }else{
            if(direction.equals("Right")) {
                // 0-2
                //go right stand
                return this.getPaths().get(0 + time%3);
            }else{
                //go left stand
                //3- 5
                return this.getPaths().get(3 + time%3);
            }

        }
    }

    public void tick() {
        setXPos(getxVel()+getXPos());
        setYPos(getyVel()+getYPos());

        //gravity
        setyVel(getyVel() +0.07);

    }
    public boolean jump(){
        if(isStand){
            this.setyVel(-4.0);
        }else{
            return false;
        }
        return true;
    }
    public String getDirection(){return direction;}
    public void setisStand(boolean b){
        isStand = b;
    }
    public boolean attack(){return stratgy.attack();}
    public boolean moveLeft(){
        this.setxVel(-2.0);
        return true;
    }
    public boolean moveRight(){
        this.setxVel(2.0);
        return true;
    }
    public boolean stopMoving(){
        this.setxVel(0.0);
        return true;
    }
    public void Hurt(int damage){
        life -= damage;
//        System.out.println(life);
    }
    public int getLife(){return life;}
    public boolean died(){
        if(life<=0){
            return true;
        }
        return false;
    }
}

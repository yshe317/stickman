package stickman.model;
import javafx.scene.input.KeyCombination;
import stickman.model.entity.*;

import java.util.List;
import java.util.ArrayList;

public class LevelImp implements Level{
    List<Entity> entitys = new ArrayList<Entity>();
    List<FixedEntity> FixedEntities = new ArrayList<FixedEntity>();
    List<MovableEntity> EnermyEntities = new ArrayList<MovableEntity>();
    List<MovableEntity> bullets = new ArrayList<MovableEntity>();
    Hero hero;
    int point;
    boolean failed;
    double height;
    double width;
    boolean passed;
    double FloorHeight;
    double heroInitx;
    double heroInity;
    public LevelImp(double height, double width){
        point = 0;
        passed = false;
        failed = false;
        this.height = height;
        this.width = width;
        FloorHeight = 300.0;
    }
    @Override
    public List<Entity> getEntities() {
        return entitys;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public void tick() {
        hero.tick();
        // check if the hero has collosion
        boolean isStand = false;
        if(hero.getXPos()<= 0 && hero.getxVel()<0){ hero.setxVel(0);}
        if(hero.getXPos()>= width && hero.getxVel()>0){ hero.setxVel(0);}
        if(hero.getYPos()<= 400 - height && hero.getyVel()<0) {hero.setyVel(0);} //400 is pane.getHeight
        if(hero.getYPos()>= FloorHeight-hero.getHeight() && hero.getyVel()>0) {hero.setyVel(0);hero.setYPos(FloorHeight-hero.getHeight());isStand = true;}

        for(int i = 0; i<FixedEntities.size(); i++) {
            FixedEntity entity = FixedEntities.get(i);
            if (collosion((Entity)entity,(Entity)hero)) {
                //System.out.println(entity.interaction());
                boolean temp  = handleCollosion(entity, hero);
                isStand = isStand || temp;
            }
        }
        hero.setisStand(isStand);

        //enermy moving
        for(int i = 0;i < EnermyEntities.size();i ++){
            MovableEntity m = EnermyEntities.get(i);
            m.tick();
            //enermy touch hero
            if(collosion((Entity)m,(Entity)hero)){
                hero.Hurt(1);
                hero.setYPos(heroInity);
                hero.setXPos(heroInitx);
            }
            //gravity
            m.setyVel(m.getyVel()+0.07);
            for(int j = 0; j<FixedEntities.size(); j++) {
                FixedEntity entity  = FixedEntities.get(j);
                if(collosion((Entity)entity,(Entity)m)) {
                    if (entity.isPlatForm()) {
                        m.setyVel(0.0);
                    }
                }else if(m.getYPos()+m.getHeight()>= FloorHeight){
                    m.setyVel(0.0);
                    m.setYPos(FloorHeight - m.getHeight() +1);

                }
            }

        }
        //bullet shooting
        for(int i = 0;i<bullets.size();){
            MovableEntity bullet = bullets.get(i);
            bullet.tick();
            if(bullet.getXPos()<=0 || bullet.getXPos()>= width) {
                entitys.remove(bullet);
                bullets.remove(bullet);

                continue;
            }
            Boolean hitted = false;
            for(int j = 0;j < EnermyEntities.size();){
                MovableEntity enermy = EnermyEntities.get(j);
                if(collosion((Entity)enermy,(Entity)bullet)){
                    EnermyEntities.remove(enermy);
                    entitys.remove(enermy);
                    point += 100;
                    hitted = true;
                    continue;
                }
                j++;
            }
            if(hitted){
                entitys.remove(bullet);
                bullets.remove(bullet);
                continue;
            }
            i++;
        }
        if(hero.died()){
            failed = true;
        }

    }
    //handle collison between hero and fixedentity
    private boolean handleCollosion(FixedEntity entity, Hero hero){
        boolean isStand = false;
            // when hero touch platform
            if(entity.isPlatForm()) {
//                System.out.println(hero.getxVel());
//                System.out.println(hero.getXPos());

                if(hero.getXPos()+hero.getWidth()-hero.getxVel() <= entity.getXPos() && hero.getxVel() > 0 && !(hero.getYPos() +hero.getHeight() -1 <= entity.getYPos())){
                    System.out.println("Left to Right");
                    hero.setXPos(entity.getXPos()-hero.getWidth());
                    hero.setyVel(0);
                    hero.setxVel(0);
                }else if(hero.getXPos()-hero.getxVel() >= entity.getXPos()+entity.getWidth() && hero.getxVel() < 0&&!(hero.getYPos() +hero.getHeight() -1 <= entity.getYPos())){
                    System.out.println("Right to Left");
                    hero.setXPos(entity.getXPos()+entity.getWidth());
                    hero.setyVel(0);
                    hero.setxVel(0);
                }else if (hero.getyVel() >= 0&& hero.getYPos()-hero.getyVel()+hero.getHeight()-1 <= entity.getYPos()) {
                    hero.setyVel(0);
                    hero.setYPos(entity.getYPos() - hero.getHeight()+1);
                }else if(hero.getyVel() < 0&& hero.getYPos()-hero.getyVel()>=entity.getYPos()){
                    hero.setyVel(0);
                    hero.setYPos(entity.getYPos() + entity.getHeight());
                }
                isStand = true;
            }else{
                //when hero touch the flag or mushroom
                String command = entity.interaction();
                if(command.equals("mushroom")){
                    //.out.println("mushroom");
                    FixedEntities.remove(entity);
                    entitys.remove(entity);
                    hero.setStratgy();
                }else if(command.equals("nextLevel")){
                    point += 1000;
                    passed = true;
                }
            }

        return isStand;
    }
    @Override
    public double getFloorHeight() {
        return FloorHeight;
    }

    @Override
    public double getHeroX() {
        return hero.getXPos();
    }
    public double getHeroY(){
        return hero.getYPos();
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public boolean jump() {
        return hero.jump();
    }

    @Override
    public boolean moveLeft() {
        return this.hero.moveLeft();
    }

    @Override
    public boolean moveRight() { return hero.moveRight();
    }

    @Override
    public boolean stopMoving() {
        return hero.stopMoving();
    }

    @Override
    public boolean passed() {
        return passed;
    }

    @Override
    public int getPoint() {
        return point;
    }

    private boolean collosion(Entity entity,Entity second){
        return (second.getXPos() < (entity.getXPos()+entity.getWidth())) &&
                ((second.getXPos() + second.getWidth()) > entity.getXPos()) &&
                (second.getYPos() < (entity.getYPos() + entity.getHeight())) &&
                ((second.getYPos() + second.getHeight()) > entity.getYPos());
    }
    public boolean attack(){
        if(hero.attack()){
            MovableEntity bullet = new Bullet(hero.getXPos(),hero.getYPos()+ hero.getHeight()/2,5,10,hero.getDirection());
            bullets.add(bullet);
            entitys.add(bullet);
            return true;
        }
        return false;
    }

    @Override
    public boolean failed() {
        return failed;
    }

    public void addFixEntity(FixedEntity entity){
        entitys.add(entity);
        FixedEntities.add(entity);
    }
    public void addMovableEntity(MovableEntity entity){
        entitys.add(entity);
        EnermyEntities.add(entity);
    }
    public void initHero(Hero hero){
        entitys.add(hero);
        this.hero = hero;
        heroInitx = hero.getXPos();
        heroInity = hero.getYPos();
    }
}

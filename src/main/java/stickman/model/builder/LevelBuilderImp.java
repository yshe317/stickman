package stickman.model.builder;
import stickman.model.Level;
import stickman.model.LevelImp;

import stickman.model.entity.*;
public class LevelBuilderImp implements LevelBuilder{
    Level level;

    public LevelBuilderImp(double height, double width){
        level = new LevelImp(height,width);
    }

    @Override
    public void buildHero(String size,double x, double y) {
        double width = 20.0;
        double height = 34.0;
        if(size.equals("large")){
            width*=2;
            height*=2;
        }
        Hero hero = new Hero(x,y,height,width);
        level.initHero(hero);
    }

    @Override
    public void buildEnermy(double x,double y,int type) {
        MovableEntity enermy = new EnermyEntity(x,y,16,16,type);
        level.addMovableEntity(enermy);
    }

    @Override
    public void buildFlag(double x, double y) {
        FixedEntity flag = new Flag(x,y);
        level.addFixEntity(flag);
    }

    @Override
    public void buildFootTile(double x,double y) {
        FixedEntity footTile = new FootTile(x,y);
        level.addFixEntity(footTile);
    }

    @Override
    public void buildMushroom(double x, double y) {
        FixedEntity mushroom = new Mushroom(x,y);
        level.addFixEntity(mushroom);
    }

    @Override
    public Level getLevel() {
        return level;
    }
}

package stickman.model.builder;

import stickman.model.Level;
//used to build a level
public interface LevelBuilder {
    //build hero
    public void buildHero(String size,double x, double y);
    //build Enermy
    public void buildEnermy(double x,double y,int type);
    //build flag
    public void buildFlag(double x,double y);
    //build foot_tile
    public void buildFootTile(double x,double y);
    //build mushroom
    public void buildMushroom(double x,double y);
    //return the level
    public Level getLevel();
}

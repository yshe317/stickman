package stickman.model;

import stickman.model.entity.Entity;
import stickman.model.entity.FixedEntity;
import stickman.model.entity.Hero;
import stickman.model.entity.MovableEntity;

import java.util.List;

public interface Level {
    List<Entity> getEntities();
    double getHeight();
    double getWidth();

    void tick();

    double getFloorHeight();
    double getHeroX();
    double getHeroY();
    Hero getHero();
    boolean jump();
    boolean moveLeft();
    boolean moveRight();
    boolean stopMoving();
    boolean attack();
    boolean failed();
    boolean passed();
    int getPoint();
    public void initHero(Hero hero);
    public void addFixEntity(FixedEntity entity);
    public void addMovableEntity(MovableEntity entity);
}

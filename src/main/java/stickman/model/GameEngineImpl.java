package stickman.model;
import stickman.model.entity.Hero;
import java.util.List;
import java.util.ArrayList;


public class GameEngineImpl implements GameEngine{
    List<Level> levels = new ArrayList<Level>();
    int currentlevel;
    int count;
    public GameEngineImpl(String jsonPath){
        currentlevel = 0;
        JsonReader reader = new JsonReader(jsonPath);
        count = 0;
        reader.initLevels(levels);
    }
    @Override
    public Level getCurrentLevel() {
        return levels.get(currentlevel);
    }

    @Override
    public void startLevel() {

    }

    @Override
    public boolean jump() {
        return getCurrentLevel().jump();
    }

    @Override
    public boolean moveLeft() {
        return getCurrentLevel().moveLeft();
    }

    @Override
    public boolean moveRight() {
        return getCurrentLevel().moveRight();
    }

    @Override
    public boolean stopMoving() { return getCurrentLevel().stopMoving(); }

    @Override
    public boolean attack() {  return getCurrentLevel().attack(); }

    @Override
    public void tick() {

        if(getCurrentLevel().passed()) {
            //passed
            count++;
            if(count == 300){
                if(currentlevel+1 < levels.size()) {
                    currentlevel++;
                }
                else{
                    System.out.println("passed all levels");
                }
            }

        }else if(getCurrentLevel().failed()){
            //failed
            System.out.println("quit");
        }
        else{
            //game running
            getCurrentLevel().tick();
            count = 0;
        }
    }


}

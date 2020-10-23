package stickman.model;

import org.junit.Test;

public class GameEngineTest {

    @Test
    public void ConstructorTest(){
        GameEngineImpl model = new GameEngineImpl("src/main/resources/configuration.json");
        assert(true);
    }
}


package stickman.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import stickman.model.builder.LevelBuilder;
import stickman.model.builder.LevelBuilderImp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
public class JsonReader{
    private List<Level> levels;
    private JSONArray mainobj;
    public JsonReader(String jsonPath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonPath)){
            mainobj = (JSONArray) jsonParser.parse(reader);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public String getStickmanSize(JSONObject level) {
        String stickman_size;
        stickman_size = (String)level.get("stickmanSize");
        return stickman_size;
    }

    public void initLevels(List<Level> levels){
        this.levels = levels;
        this.mainobj.forEach(level-> readSingleLevel( (JSONObject) level));
    }

    private void readSingleLevel(JSONObject level) {
        JSONObject levelStructure = (JSONObject)level.get("levelStructure");
        JSONObject levelSize = (JSONObject)levelStructure.get("levelSize");
        double width = ((Number)levelSize.get("width")).doubleValue();
        double height = ((Number)levelSize.get("height")).doubleValue();
        LevelBuilder builder = new LevelBuilderImp(height,width);
        buildHero(builder,levelStructure);
        buildFootTile(builder,levelStructure);
        buildFlag(builder,levelStructure);
        buildEnermy(builder,levelStructure);
        buildMushroom(builder,levelStructure);
        levels.add(builder.getLevel());
    }

    private void buildHero(LevelBuilder builder,JSONObject levelStructure){
        String size = (String)levelStructure.get("stickmanSize");
        JSONObject stickmanPos = (JSONObject)levelStructure.get("stickmanPos");
        double x = ((Number)stickmanPos.get("x")).doubleValue();
        double y = ((Number)stickmanPos.get("y")).doubleValue();
        builder.buildHero(size,x,y);
    }

        private void buildFootTile(LevelBuilder builder,JSONObject levelStructure){
        JSONArray footTiles= (JSONArray)levelStructure.get("foot_tile");
        for(int i = 0;i<footTiles.size();i++) {
            double x = ((Number)((JSONObject)footTiles.get(i)).get("x")).doubleValue();
            double y = ((Number)((JSONObject)footTiles.get(i)).get("y")).doubleValue();
            builder.buildFootTile(x,y);
        }
    }
    private void buildFlag(LevelBuilder builder,JSONObject levelStructure){
        JSONObject flag = (JSONObject)levelStructure.get("flag");
        double x =((Number)flag.get("x")).doubleValue();
        double y =((Number)flag.get("y")).doubleValue();
        builder.buildFlag(x,y);
    }
    private void buildEnermy(LevelBuilder builder,JSONObject levelStructure){
        JSONArray enermies= (JSONArray)levelStructure.get("enermies");
        for(int i = 0;i<enermies.size();i++) {
            double x = ((Number)((JSONObject)enermies.get(i)).get("x")).doubleValue();
            double y = ((Number)((JSONObject)enermies.get(i)).get("y")).doubleValue();
            int type = ((Number)((JSONObject)enermies.get(i)).get("type")).intValue();
            builder.buildEnermy(x,y,type);
        }
    }
    private void buildMushroom(LevelBuilder builder,JSONObject levelStructure){
        JSONArray mushroom= (JSONArray)levelStructure.get("mushroom");
        for(int i = 0;i<mushroom.size();i++) {
            double x = ((Number)((JSONObject)mushroom.get(i)).get("x")).doubleValue();
            double y = ((Number)((JSONObject)mushroom.get(i)).get("y")).doubleValue();
            builder.buildMushroom(x,y);
        }
    }
}
// reference : https://www.geeksforgeeks.org/parse-json-java/

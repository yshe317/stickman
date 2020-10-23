package stickman.view;

import javafx.scene.layout.Pane;
import stickman.model.Level;
import javafx.scene.text.Text;
public class FinishSummaryImp implements FinishSummary{
    Text mainword;
    boolean deleted;
    int levelcount;
    Text subword;
    Text failed;
    boolean fail;
    public FinishSummaryImp() {
        deleted = false;
        fail = false;
        subword = new Text(240,220,"");
        levelcount = 1;
        mainword = new Text(290,200,"passed");
        failed = new Text(290,200,"Failed");
    }    @Override
    public void setText(Level level) {
        if(!deleted) {
            String sub = String.format("Level %d. Your points: %d", levelcount, level.getPoint());
            subword.setText(sub);
        }
    }

    @Override
    public void showOnPane(Pane pane) {
        if(!deleted) {
            pane.getChildren().add(mainword);
            pane.getChildren().add(subword);
            deleted = true;
            levelcount ++;
        }
    }
    public void clean(Pane pane){
        if(deleted){
            pane.getChildren().remove(mainword);
            pane.getChildren().remove(subword);
            deleted = false;
        };
    }

    @Override
    public void showFailed(Pane pane) {
        if(!fail) {
            pane.getChildren().add(failed);
            fail = true;
        }
    }
}

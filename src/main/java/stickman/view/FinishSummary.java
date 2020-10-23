package stickman.view;
import stickman.model.Level;
import javafx.scene.layout.Pane;
public interface FinishSummary {
    void setText(Level level);
    void showOnPane(Pane pane);
    void clean(Pane pane);
    void showFailed(Pane pane);
}

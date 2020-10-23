package stickman.view;

import javafx.scene.Node;
import stickman.model.entity.Entity;

public interface EntityView {
    void update(double xViewportOffset, double yViewportOffset);

    boolean matchesEntity(Entity entity);

    void markForDelete();

    Node getNode();

    boolean isMarkedForDelete();
}

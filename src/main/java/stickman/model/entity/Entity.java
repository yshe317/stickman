package stickman.model.entity;

public interface Entity {
    String getImagePath();
    double getXPos();
    double getYPos();
    double getHeight();
    double getWidth();
    Layer getLayer();

    enum Layer{
            BACKGROUND, FOREGROUND, EFFECT
    }
}

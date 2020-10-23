package stickman.model.entity;

public abstract class FixedEntity implements Entity{
    double XPos;
    double YPos;
    double height;
    double width;
    Layer layer;
    String ImagePath;
    public FixedEntity(double x, double y){
        XPos = x;
        YPos = y;
    }

    public abstract boolean isPlatForm();
    public abstract String interaction();
    @Override
    public double getXPos() {
        return XPos;
    }

    @Override
    public double getYPos() { return YPos; }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public Layer getLayer() {
        return layer;
    }

    @Override
    public String getImagePath() { return ImagePath; }


}

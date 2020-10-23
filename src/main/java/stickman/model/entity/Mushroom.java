package stickman.model.entity;

public class Mushroom extends FixedEntity{
    public Mushroom(double x, double y) {
        super(x, y);
        layer = Layer.FOREGROUND;
        width = 16;
        height = 16;
        ImagePath = "mushroom.png";
    }

    @Override
    public boolean isPlatForm() {
        return false;
    }

    @Override
    public String interaction() {
        return "mushroom";
    }
}

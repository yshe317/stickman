package stickman.model.entity;

public class Flag extends FixedEntity{


    public Flag(double x, double y) {
        super(x, y);
        height = 16;
        width = 16;
        ImagePath = "flag.png";
        layer =Layer.FOREGROUND;
    }

    @Override
    public boolean isPlatForm() {
        return false;
    }

    @Override
    public String interaction() {
        return "nextLevel";
    }
}

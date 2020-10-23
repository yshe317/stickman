package stickman.model.entity;

public class FootTile extends FixedEntity{
    public FootTile(double x, double y) {
        super(x, y);
        height = 16;
        this.width = 16;
        ImagePath = "foot_tile.png";
        layer = Layer.BACKGROUND;
    }

    @Override
    public boolean isPlatForm() {
        return true;
    }

    @Override
    public String interaction() {
        return null;
    }

}

package EntityLayer;

public class Plate extends Tableware<Plate> {
    private String shape;
    private String color;

    public String getShape() {
        return shape;
    }
    public Plate setShape(String shape) {
        this.shape = shape;
        return this;
    }

    public String getColor() {
        return color;
    }
    public Plate setColor(String color) {
        this.color = color;
        return this;
    }
    @Override
    public String toString() {
        return "Cup{" + String.join(", ", commonField(), "shape=" + shape, "color=" + color) + "}";
    }

    @Override
    public String commonField() {
        return super.commonField() + ", shape='" + getShape() + ", color='" + getColor();
    }

}

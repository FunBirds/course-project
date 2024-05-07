package entity;

public class Spoon extends Tableware<Spoon>{
    private String type;
    private String color;

    public String getType() {
        return type;
    }

    public Spoon setType(String type) {
        this.type = type;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Spoon setColor(String color) {
        this.color = color;
        return this;
    }
    @Override
    public String toString() {
        return "Cup{" + String.join(", ", commonField(), "type=" + type, "color=" + color) + "}";
    }

    @Override
    public String commonField() {
        return super.commonField() + ", type='" + getType() + ", color='" + getColor();
    }
}

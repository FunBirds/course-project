package entity;

public class Pot extends Tableware<Pot>{
    private String type;
    private String color;

    public String getType() {
        return type;
    }

    public Pot setType(String type) {
        this.type = type;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Pot setColor(String color) {
        this.color = color;
        return this;
    }
    @Override
    public String toString() {
        return "Pot {" + String.join(", ", commonField(), "type=" + type, "color=" + color) + "}";
    }

    @Override
    public String commonField() {
        return super.commonField() + ", type='" + getType() + ", color='" + getColor();
    }
}

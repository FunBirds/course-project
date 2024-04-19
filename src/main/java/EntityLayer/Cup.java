package EntityLayer;

public class Cup extends Tableware<Cup>{
    private String color;
    private String size;
    private Double volume;

    public String getColor() {
        return color;
    }

    public Cup setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Cup setSize(String size) {
        this.size = size;
        return this;
    }

    public Double getVolume() {
        return volume;
    }

    public Cup setVolume(Double volume) {
        this.volume = volume;
        return this;
    }
    @Override
    public String toString() {
        return "Cup{" + String.join(", ", commonField(), "size=" + size, "color=" + color, "volume=" + volume) + "}";
    }

    @Override
    public String commonField() {
        return super.commonField() + ", color='" + getColor() + ", size='" + getSize() + ", volume=" + getVolume();
    }

}

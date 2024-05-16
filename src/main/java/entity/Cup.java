package entity;

/**
 * This class represents a Cup which is a type of Tableware.
 * It has three properties: color, size, and volume.
 */
public class Cup extends Tableware<Cup>{
    private String color;
    private String size;
    private Double volume;

    /**
     * Returns the color of the Cup.
     * @return A string representing the color of the Cup.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the Cup.
     * @param color A string representing the color of the Cup.
     * @return The current Cup instance.
     */
    public Cup setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Returns the size of the Cup.
     * @return A string representing the size of the Cup.
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the Cup.
     * @param size A string representing the size of the Cup.
     * @return The current Cup instance.
     */
    public Cup setSize(String size) {
        this.size = size;
        return this;
    }

    /**
     * Returns the volume of the Cup.
     * @return A Double representing the volume of the Cup.
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * Sets the volume of the Cup.
     * @param volume A Double representing the volume of the Cup.
     * @return The current Cup instance.
     */
    public Cup setVolume(Double volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Returns a string representation of the Cup.
     * @return A string representing the Cup.
     */
    @Override
    public String toString() {
        return "Cup{" + String.join(", ", commonField(), "size=" + size, "color=" + color, "volume=" + volume) + "}";
    }

    /**
     * Returns a string representation of the common fields of the Cup.
     * @return A string representing the common fields of the Cup.
     */
    @Override
    public String commonField() {
        return super.commonField() + ", color='" + getColor() + ", size='" + getSize() + ", volume=" + getVolume();
    }
}
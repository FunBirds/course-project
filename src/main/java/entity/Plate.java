package entity;

/**
 * This class represents a Plate which is a type of Tableware.
 * It has two properties: shape and color.
 */
public class Plate extends Tableware<Plate> {
    private String shape;
    private String color;

    /**
     * Returns the shape of the Plate.
     * @return A string representing the shape of the Plate.
     */
    public String getShape() {
        return shape;
    }

    /**
     * Sets the shape of the Plate.
     * @param shape A string representing the shape of the Plate.
     * @return The current Plate instance.
     */
    public Plate setShape(String shape) {
        this.shape = shape;
        return this;
    }

    /**
     * Returns the color of the Plate.
     * @return A string representing the color of the Plate.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the Plate.
     * @param color A string representing the color of the Plate.
     * @return The current Plate instance.
     */
    public Plate setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Returns a string representation of the Plate.
     * @return A string representing the Plate.
     */
    @Override
    public String toString() {
        return "Plate {" + String.join(", ", commonField(), "shape=" + shape, "color=" + color) + "}";
    }

    /**
     * Returns a string representation of the common fields of the Plate.
     * @return A string representing the common fields of the Plate.
     */
    @Override
    public String commonField() {
        return super.commonField() + ", shape='" + getShape() + ", color='" + getColor();
    }
}
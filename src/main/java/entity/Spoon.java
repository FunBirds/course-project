package entity;

/**
 * This class represents a Spoon which is a type of Tableware.
 * It has two properties: type and color.
 */
public class Spoon extends Tableware<Spoon>{
    private String type;
    private String color;

    /**
     * Returns the type of the Spoon.
     * @return A string representing the type of the Spoon.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the Spoon.
     * @param type A string representing the type of the Spoon.
     * @return The current Spoon instance.
     */
    public Spoon setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Returns the color of the Spoon.
     * @return A string representing the color of the Spoon.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the Spoon.
     * @param color A string representing the color of the Spoon.
     * @return The current Spoon instance.
     */
    public Spoon setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Returns a string representation of the Spoon.
     * @return A string representing the Spoon.
     */
    @Override
    public String toString() {
        return "Spoon {" + String.join(", ", commonField(), "type=" + type, "color=" + color) + "}";
    }

    /**
     * Returns a string representation of the common fields of the Spoon.
     * @return A string representing the common fields of the Spoon.
     */
    @Override
    public String commonField() {
        return super.commonField() + ", type='" + getType() + ", color='" + getColor();
    }
}
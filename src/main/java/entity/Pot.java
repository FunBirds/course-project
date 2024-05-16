package entity;

/**
 * This class represents a Pot which is a type of Tableware.
 * It has two properties: type and color.
 */
public class Pot extends Tableware<Pot>{
    private String type;
    private String color;

    /**
     * Returns the type of the Pot.
     * @return A string representing the type of the Pot.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the Pot.
     * @param type A string representing the type of the Pot.
     * @return The current Pot instance.
     */
    public Pot setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Returns the color of the Pot.
     * @return A string representing the color of the Pot.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the Pot.
     * @param color A string representing the color of the Pot.
     * @return The current Pot instance.
     */
    public Pot setColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Returns a string representation of the Pot.
     * @return A string representing the Pot.
     */
    @Override
    public String toString() {
        return "Pot {" + String.join(", ", commonField(), "type=" + type, "color=" + color) + "}";
    }

    /**
     * Returns a string representation of the common fields of the Pot.
     * @return A string representing the common fields of the Pot.
     */
    @Override
    public String commonField() {
        return super.commonField() + ", type='" + getType() + ", color='" + getColor();
    }
}
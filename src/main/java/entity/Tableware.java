package entity;


import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class Tableware<SELF extends Tableware<SELF>> {
    private String name;
    private Double price;
    private String material;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public SELF setName(String name) {
        this.name = name;
        return (SELF) this;
    }

    public Double getPrice() {
        return price;
    }

    public SELF setPrice(Double price) {
        this.price = price;
        return (SELF) this;
    }

    public String getMaterial() {
        return material;
    }

    public SELF setMaterial(String material) {
        this.material = material;
        return (SELF) this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public SELF setQuantity(Integer quantity) {
        this.quantity = quantity;
        return (SELF) this;
    }

    @Override
    public String toString() {
        return "Tableware{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    public String commonField() {
        return "name=" + name + ", price=" + price + ", material='" + material + ", quantity=" + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tableware<?> other = (Tableware<?>) obj;
        return Objects.equals(name, other.name) && Objects.equals(price, other.price) && Objects.equals(material, other.material) && Objects.equals(quantity, other.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, material, quantity);
    }
}

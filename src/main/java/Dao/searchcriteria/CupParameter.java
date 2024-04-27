package Dao.searchcriteria;


import EntityLayer.Cup;

import java.util.Objects;

public class CupParameter implements Parameter<Cup> {
    private final String name;
    private final Double value;
    private final String size;

    public CupParameter(String name, Double value, String size) {
        this.name = name;
        this.value = value;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Cup Parameter [size=" + size + " name=" + name + ", value=" + value + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, value, size);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CupParameter other = (CupParameter) obj;
        return Objects.equals(name, other.name) && Objects.equals(value, other.value) && Objects.equals(size, other.size);
    }

    @Override
    public boolean test(Cup appliance) {
        return false;
    }
}

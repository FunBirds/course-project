package Dao.searchcreteria.parameter;

import Dao.searchcreteria.Parameter;
import EntityLayer.Cup;

public record ColorParameter(String color) implements Parameter<Cup> {
    public ColorParameter {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color can't be empty");
        }
    }

    @Override
    public boolean test(Cup component) {
        return color.equals(component.getColor());
    }
}

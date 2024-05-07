package dao.criteria.parameter.cupParameters;

import dao.criteria.Parameter;
import entity.Cup;

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

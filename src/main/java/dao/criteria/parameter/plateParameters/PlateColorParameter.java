package dao.criteria.parameter.plateParameters;

import dao.criteria.Parameter;
import entity.Plate;

public record PlateColorParameter(String color) implements Parameter<Plate> {
    public PlateColorParameter {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color can't be empty");
        }
    }

    @Override
    public boolean test(Plate component) {
        return color.equals(component.getColor());
    }
}

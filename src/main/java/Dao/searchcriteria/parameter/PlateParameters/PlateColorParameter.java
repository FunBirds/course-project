package Dao.searchcriteria.parameter.PlateParameters;

import Dao.searchcriteria.Parameter;
import EntityLayer.Plate;

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

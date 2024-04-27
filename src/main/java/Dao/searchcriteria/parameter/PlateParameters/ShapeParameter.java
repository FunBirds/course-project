package Dao.searchcriteria.parameter.PlateParameters;

import Dao.searchcriteria.Parameter;
import EntityLayer.Plate;

public record ShapeParameter(String shape) implements Parameter<Plate> {
    public ShapeParameter {
        if (shape == null || shape.isBlank()) {
            throw new IllegalArgumentException("Shape can't be empty");
        }
    }

    @Override
    public boolean test(Plate component) {
        return shape.equals(component.getShape());
    }
}

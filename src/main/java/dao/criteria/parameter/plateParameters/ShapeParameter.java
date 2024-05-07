package dao.criteria.parameter.plateParameters;

import dao.criteria.Parameter;
import entity.Plate;

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

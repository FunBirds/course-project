package dao.criteria.parameter.spoonParameters;

import dao.criteria.Parameter;
import entity.Spoon;

public record SpoonTypeParameter(String type) implements Parameter<Spoon> {
    public SpoonTypeParameter {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null");
        }
    }
    @Override
    public boolean test(Spoon spoon) {
        return spoon.getType().equals(type);
    }
}

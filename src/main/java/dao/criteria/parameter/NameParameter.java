package dao.criteria.parameter;

import dao.criteria.Parameter;
import entity.Tableware;

public record NameParameter<A extends Tableware<A>>(String name) implements Parameter<A> {
    public NameParameter {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return name.equals(appliance.getName());
    }
}

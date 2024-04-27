package Dao.searchcreteria.parameter;

import Dao.searchcreteria.Parameter;
import EntityLayer.Tableware;

public record MaterialParameter<A extends Tableware<A>>(String material) implements Parameter<A> {
    public MaterialParameter {
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException("Material can't be empty");
        }
    }

    @Override
    public boolean test(A appliance) {
        return material.equals(appliance.getMaterial());
    }
}

package Dao.searchcriteria.parameter.PotParameters;

import Dao.searchcriteria.Parameter;
import EntityLayer.Pot;

public record TypeParameter(String type) implements Parameter<Pot> {
    public TypeParameter {
        if(type == null|| type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or blank");
        }
    }
    @Override
    public boolean test(Pot component) {
        return type.equals(component.getType());
    }
}

package dao.criteria.parameter.cupParameters;

import dao.criteria.Parameter;
import entity.Cup;

public record SizeParameter(String size) implements Parameter<Cup>{

    public SizeParameter {
        if(size == null || size.isBlank() ){
            throw new IllegalArgumentException("Size can't be empty ");
        }
    }
    @Override
    public boolean test(Cup appliance) {
        return size.equals(appliance.getSize());
    }
}

package Dao.searchcriteria;

import EntityLayer.Tableware;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<C extends Tableware<C>> implements SearchCriteria<C> {
    protected final Map<Class<?>, Parameter<C>> parameters = new HashMap<>();

    @Override
    public <P extends Parameter<C>> SearchCriteria<C> addParameter(P parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(C component) {
        return parameters.values().stream().allMatch(p -> p.test(component));
    }
}

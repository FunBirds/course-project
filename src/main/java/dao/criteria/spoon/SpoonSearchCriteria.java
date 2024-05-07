package dao.criteria.spoon;

import dao.criteria.AbstractCriteria;
import entity.Spoon;

public class SpoonSearchCriteria extends AbstractCriteria<Spoon> {
    @Override
    public Class<Spoon> getTablewareType() {
        return Spoon.class;
    }
}

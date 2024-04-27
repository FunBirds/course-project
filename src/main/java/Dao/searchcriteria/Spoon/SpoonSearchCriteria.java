package Dao.searchcriteria.Spoon;

import Dao.searchcriteria.AbstractCriteria;
import EntityLayer.Spoon;

public class SpoonSearchCriteria extends AbstractCriteria<Spoon> {
    @Override
    public Class<Spoon> getTablewareType() {
        return Spoon.class;
    }
}

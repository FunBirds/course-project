package dao.criteria.pot;

import dao.criteria.AbstractCriteria;
import entity.Pot;

public class PotSearchCriteria extends AbstractCriteria<Pot> {
    @Override
    public Class<Pot> getTablewareType() {
        return Pot.class;
    }
}

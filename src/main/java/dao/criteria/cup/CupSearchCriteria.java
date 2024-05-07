package dao.criteria.cup;

import dao.criteria.AbstractCriteria;
import entity.Cup;

public class CupSearchCriteria extends AbstractCriteria<Cup> {
    @Override
    public Class<Cup> getTablewareType() {
        return Cup.class;
    }
}

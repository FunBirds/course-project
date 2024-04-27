package Dao.searchcriteria.Cup;

import Dao.searchcriteria.AbstractCriteria;
import EntityLayer.Cup;

public class CupSearchCriteria extends AbstractCriteria<Cup> {
    @Override
    public Class<Cup> getTablewareType() {
        return Cup.class;
    }
}

package Dao.searchcreteria;

import EntityLayer.Cup;

public class CupSearchCriteria extends AbstractCriteria<Cup>{
    @Override
    public Class<Cup> getTablewareType() {
        return Cup.class;
    }
}

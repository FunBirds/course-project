package Dao.searchcriteria.Pot;

import Dao.searchcriteria.AbstractCriteria;
import EntityLayer.Pot;

public class PotSearchCriteria extends AbstractCriteria<Pot> {
    @Override
    public Class<Pot> getTablewareType() {
        return Pot.class;
    }
}

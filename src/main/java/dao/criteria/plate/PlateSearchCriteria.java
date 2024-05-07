package dao.criteria.plate;

import dao.criteria.AbstractCriteria;
import entity.Plate;

public class PlateSearchCriteria extends AbstractCriteria<Plate> {
    @Override
    public Class<Plate> getTablewareType() {
        return Plate.class;
    }
}

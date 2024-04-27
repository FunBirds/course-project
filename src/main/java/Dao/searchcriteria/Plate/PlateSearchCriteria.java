package Dao.searchcriteria.Plate;

import Dao.searchcriteria.AbstractCriteria;
import EntityLayer.Plate;

public class PlateSearchCriteria extends AbstractCriteria<Plate> {
    @Override
    public Class<Plate> getTablewareType() {
        return Plate.class;
    }
}

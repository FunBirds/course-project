package Service;

import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Tableware;

import java.util.Collection;

public enum ServiceFactory {
    INSTANCE;

    public TablewareService getTablewareService() {
        return new TablewareService() {
            @Override
            public <A extends Tableware<A>> Collection<A> find(SearchCriteria<A> criteria) {
                return null;
            }
        };
    }
}

package Service;

import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Tableware;
import Service.impl.TablewareServiceImpl;

import java.util.Collection;

public enum ServiceFactory {
    INSTANCE;

    private final TablewareService tablewareService = new TablewareServiceImpl();

    private ServiceFactory() {}

    public TablewareService getTablewareService() {
        return new TablewareService() {
            @Override
            public <A extends Tableware<A>> Collection<A> find(SearchCriteria<A> criteria) {
                return null;
            }
        };
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }
}

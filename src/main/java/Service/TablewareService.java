package Service;

import Dao.searchcreteria.SearchCriteria;
import EntityLayer.Tableware;

import java.util.Collection;
import java.util.List;

public interface TablewareService {
    <A extends Tableware<A>> Collection<A> find(SearchCriteria<A> criteria);
}

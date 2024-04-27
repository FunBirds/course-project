package Service;

import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Tableware;

import java.util.Collection;

public interface TablewareService {
    <A extends Tableware<A>> Collection<A> find(SearchCriteria<A> criteria);
}

package Service.impl;

import Dao.DaoFactory;
import Dao.TablewareDao;
import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Cup;
import EntityLayer.Tableware;
import Service.TablewareService;
import java.util.Collection;


public class TablewareServiceImpl implements TablewareService {

    @Override
    public <A extends Tableware<A>> Collection<A> find(SearchCriteria<A> criteria) {
//        try {
//            TablewareDao<Cup> product = DaoFactory.INSTANCE.getTablewareDAO(criteria.class);
//        }catch (Exception e){
//            throw new IllegalArgumentException(e.getMessage());
//        }
        return null;
    }
}

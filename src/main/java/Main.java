import Dao.DaoFactory;
import Dao.TablewareDao;
import Dao.searchcriteria.Cup.CupSearchCriteria;
import Dao.searchcriteria.SearchCriteria;
import Dao.searchcriteria.parameter.CupParameters.ColorParameter;
import EntityLayer.Cup;
import Exceptions.DaoException;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws DaoException {
        TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class);
        CupSearchCriteria criteria = new CupSearchCriteria();
        criteria.addParameter(new ColorParameter("Red"));
        dao.find(criteria).forEach(System.out::println);
    }
}

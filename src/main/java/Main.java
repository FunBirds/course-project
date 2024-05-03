import Dao.CupDao;
import Dao.DaoFactory;
import Dao.TablewareDao;
import Dao.searchcriteria.Cup.CupSearchCriteria;
import Dao.searchcriteria.SearchCriteria;
import Dao.searchcriteria.parameter.CupParameters.ColorParameter;
import Dao.searchcriteria.parameter.NameParameter;
import EntityLayer.Cup;
import Exceptions.DaoException;
import Exceptions.ServiceException;
import Service.impl.CupServiceImpl;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws DaoException, ServiceException {
        CupServiceImpl cupService = new CupServiceImpl();
        cupService.getProductByName("Stainless Steel Travel Mug").forEach(System.out::println);
//        cupService.getAll().forEach(System.out::println);
//        cupService.getProductByParameter(new NameParameter<>("Stainless Steel Travel Mug")).forEach(System.out::println);
//        TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class)
//        dao.find(criteria).forEach(System.out::println);
//        dao.find(criteria);
//        dao.findAll().forEach(System.out::println);
//        criteria.addParameter(new NameParameter<>("Stainless Steel Travel Mug"));
//        dao.find(criteria).forEach(System.out::println);
    }
}

package Service;

import Dao.searchcriteria.Parameter;
import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Cup;
import EntityLayer.Tableware;
import Exceptions.ServiceException;

import java.util.Collection;
import java.util.List;

public interface TablewareService<A extends Tableware<A>> {
    List<A> getProductByName(String name) throws ServiceException;
    List<A> getProductByParameter(Parameter<A> parameter) throws ServiceException;
}
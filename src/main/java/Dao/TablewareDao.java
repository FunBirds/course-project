package Dao;

import Dao.searchcreteria.SearchCriteria;
import EntityLayer.Tableware;
import exceptions.DaoException;

import java.util.List;

public interface TablewareDao<T extends Tableware<T>>  {
    List<T> find(SearchCriteria<T> criteria) throws DaoException;
}

package Dao;

import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Tableware;
import Exceptions.DaoException;

import java.util.List;

public interface TablewareDao<T extends Tableware<T>>  {
    List<T> find(SearchCriteria<T> criteria) throws DaoException;
    List<T> findAll() throws DaoException;
}

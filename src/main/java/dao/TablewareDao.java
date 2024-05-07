package dao;

import dao.criteria.SearchCriteria;
import entity.Tableware;

import java.util.List;

public interface TablewareDao<T extends Tableware<T>>  {
    List<T> find(SearchCriteria<T> criteria) throws DaoException;
    List<T> findAll() throws DaoException;
}

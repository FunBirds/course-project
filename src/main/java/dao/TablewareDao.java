package dao;

import dao.criteria.SearchCriteria;
import entity.Tableware;

import java.util.List;

/**
 * This interface represents a Data Access Object (DAO) for Tableware.
 * It provides methods to find Tableware based on certain criteria and to find all Tableware.
 * @param <T> The type of Tableware this DAO is for.
 */
public interface TablewareDao<T extends Tableware<T>>  {

    /**
     * Finds Tableware that match the specified criteria.
     * @param criteria The criteria to match.
     * @return A list of Tableware that match the criteria.
     * @throws DaoException If an error occurs while finding the Tableware.
     */
    List<T> find(SearchCriteria<T> criteria) throws DaoException;

    /**
     * Finds all Tableware.
     * @return A list of all Tableware.
     * @throws DaoException If an error occurs while finding the Tableware.
     */
    List<T> findAll() throws DaoException;
}
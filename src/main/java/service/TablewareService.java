package service;

import dao.criteria.Parameter;
import entity.Tableware;

import java.util.List;

public interface TablewareService<A extends Tableware<A>> {
    List<A> getProductByName(String name) throws ServiceException;
    List<A> getProductByParameter(Parameter<A> parameter) throws ServiceException;
}
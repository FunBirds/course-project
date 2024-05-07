package service.impl;

import dao.DaoFactory;
import dao.TablewareDao;
import dao.criteria.Parameter;
import dao.criteria.spoon.SpoonSearchCriteria;
import dao.criteria.parameter.NameParameter;
import entity.Spoon;
import service.ServiceException;
import service.SpoonService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SpoonServiceImpl implements SpoonService {
    private List<Spoon> spoons;
    TablewareDao<Spoon> dao = DaoFactory.INSTANCE.getTablewareDAO(Spoon.class);
    SpoonSearchCriteria criteria = new SpoonSearchCriteria();

    public List<Spoon> getAll() throws ServiceException {
        try {
            TablewareDao<Spoon> dao = DaoFactory.INSTANCE.getTablewareDAO(Spoon.class);
            return Objects.requireNonNull(dao).findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all products" + e.getMessage());
        }
    }

    /**
     * @param price - price of the product
     * @return List<Spoon>
     * @throws ServiceException - if error occurs while getting all spoons
     */
    @Override
    public List<Spoon> getPurchasableProducts(int price) throws ServiceException {
        try {
            getAll();
            return spoons
                    .stream()
                    .filter(e -> e.getPrice() <= price)
                    .collect(Collectors.toList());
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * @param name - name of the product
     * @return - List<Cup>
     */
    @Override
    public List getProductByName(String name) throws ServiceException {
        getAll();
        try {
            criteria.addParameter(new NameParameter<>(name));
            return dao.find(criteria);
        } catch (Exception e) {
            throw new ServiceException("Error while getting product by name");
        }
    }

    /**
     * @param parameter - parameter of the product
     * @return - List<Cup>
     * @throws ServiceException - if error occurs while getting product by parameter
     */
    @Override
    public List getProductByParameter(Parameter parameter) throws ServiceException {
        getAll();
        try {
            criteria.addParameter(parameter);
            return dao.find(criteria);
        } catch (Exception e) {
            throw new ServiceException("Error while getting product by parameter");
        }
    }
}

package service.impl;

import dao.DaoFactory;
import dao.TablewareDao;
import dao.criteria.cup.CupSearchCriteria;
import dao.criteria.Parameter;
import dao.criteria.parameter.NameParameter;
import entity.Cup;
import service.ServiceException;
import service.CupService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class CupServiceImpl implements CupService {
    private List<Cup> cups;
    TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class);
    CupSearchCriteria criteria = new CupSearchCriteria();

    /**
     * @return List<Cup>
     * @throws ServiceException - if error occurs while getting all cups
     */
    public static List<Cup> getAll() throws ServiceException {
        try {
            TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class);
            return Objects.requireNonNull(dao).findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all cups" + e.getMessage());
        }
    }

    /**
     * @param price - price of the product
     * @return List<Cup>
     */
    @Override
    public List<Cup> getPurchasableProducts(int price) throws ServiceException {
        try {
            getAll();
            return cups
                    .stream()
                    .filter(e -> e.getPrice() <= price)
                    .collect(Collectors.toList());
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * @param name - name of the product
     * @return List<Cup>
     */
    @Override
    public List<Cup> getProductByName(String name) throws ServiceException {
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
     * @return List<Cup>
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
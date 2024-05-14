package service.impl;

import dao.DaoFactory;
import dao.TablewareDao;
import dao.criteria.Parameter;
import dao.criteria.pot.PotSearchCriteria;
import dao.criteria.parameter.NameParameter;
import entity.Pot;
import entity.Spoon;
import service.ServiceException;
import service.PotService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PotServiceImpl implements PotService {
    private List<Pot> pots;
    TablewareDao<Pot> dao = DaoFactory.INSTANCE.getTablewareDAO(Pot.class);
    PotSearchCriteria criteria = new PotSearchCriteria();

    public List<Pot> getAll() throws ServiceException {
        try {
            TablewareDao<Pot> dao = DaoFactory.INSTANCE.getTablewareDAO(Pot.class);
            return Objects.requireNonNull(dao).findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all products" + e.getMessage());
        }
    }

    /**
     * @param price - price of the product
     * @return List<Pot>
     * @throws ServiceException - if error occurs while getting all pots
     */
    @Override
    public List<Pot> getPurchasableProducts(int price) throws ServiceException {
        try {
            getAll();
            return pots
                    .stream()
                    .filter(e -> e.getPrice() <= price)
                    .collect(Collectors.toList());
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * @param name - name of the product
     * @return - List<Pot>
     * @throws ServiceException - if error occurs while getting product by name
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
     * @return - List<Pot>
     * @throws ServiceException - if error occurs while getting product by parameter
     */
    @Override
    public List getProductByParameter(Parameter parameter) throws ServiceException {
        try {
            criteria.addParameter(parameter);
            return dao.find(criteria);
        } catch (Exception e) {
            throw new ServiceException("Error while getting product by parameter");
        }
    }
}

package service.impl;

import dao.DaoFactory;
import dao.TablewareDao;
import dao.criteria.Parameter;
import dao.criteria.plate.PlateSearchCriteria;
import dao.criteria.parameter.NameParameter;
import entity.Plate;
import service.ServiceException;
import service.PlateService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlateServiceImpl implements PlateService {
    private List<Plate> plate;
    TablewareDao<Plate> dao = DaoFactory.INSTANCE.getTablewareDAO(Plate.class);
    PlateSearchCriteria criteria = new PlateSearchCriteria();

    public List<Plate> getAll() throws ServiceException {
        try {
            TablewareDao<Plate> dao = DaoFactory.INSTANCE.getTablewareDAO(Plate.class);
            assert dao != null;
            this.plate = dao.findAll();
            return Objects.requireNonNull(dao).findAll();
        } catch (Exception e) {
            throw new ServiceException("Error while getting all products" + e.getMessage());
        }
    }

    /**
     * @param price - price of the product
     * @return List<Plate>
     * @throws ServiceException - if error occurs while getting all plates
     */
    @Override
    public List<Plate> getPurchasableProducts(int price) throws ServiceException {
        try {
            getAll();
            return plate
                    .stream()
                    .filter(e -> e.getPrice() <= price)
                    .collect(Collectors.toList());
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * @param name - name of the product
     * @return - List<Plate>
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
     * @return - List<Plate>
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

package Service.impl;

import Dao.DaoFactory;
import Dao.TablewareDao;
import Dao.searchcriteria.Parameter;
import Dao.searchcriteria.Plate.PlateSearchCriteria;
import Dao.searchcriteria.parameter.NameParameter;
import EntityLayer.Plate;
import Exceptions.ServiceException;
import Service.PlateService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlateServiceImpl implements PlateService {
    private List<Plate> plate;
    TablewareDao<Plate> dao = DaoFactory.INSTANCE.getTablewareDAO(Plate.class);
    PlateSearchCriteria criteria = new PlateSearchCriteria();

    public static List<Plate> getAll() throws ServiceException {
        try {
            TablewareDao<Plate> dao = DaoFactory.INSTANCE.getTablewareDAO(Plate.class);
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

package Service.impl;

import Dao.searchcriteria.Parameter;
import EntityLayer.Plate;
import Exceptions.ServiceException;
import Service.PlateService;

import java.util.List;

public class PlateServiceImpl implements PlateService {
    /**
     * @param price 
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Plate> getPurchasableProducts(int price) throws ServiceException {
        return List.of();
    }

    /**
     * @param name 
     * @return
     * @throws ServiceException
     */
    @Override
    public List getProductByName(String name) throws ServiceException {
        return List.of();
    }

    /**
     * @param parameter 
     * @return
     * @throws ServiceException
     */
    @Override
    public List getProductByParameter(Parameter parameter) throws ServiceException {
        return List.of();
    }
}

package Service.impl;

import Dao.searchcriteria.Parameter;
import EntityLayer.Pot;
import Exceptions.ServiceException;
import Service.PotService;

import java.util.List;

public class PotServiceImpl implements PotService {
    /**
     * @param price 
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Pot> getPurchasableProducts(int price) throws ServiceException {
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

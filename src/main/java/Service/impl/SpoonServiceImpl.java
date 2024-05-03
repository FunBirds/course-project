package Service.impl;

import Dao.searchcriteria.Parameter;
import EntityLayer.Spoon;
import Exceptions.ServiceException;
import Service.SpoonService;

import java.util.List;

public class SpoonServiceImpl implements SpoonService {
    /**
     * @param price 
     * @return
     * @throws ServiceException
     */
    @Override
    public List<Spoon> getPurchasableProducts(int price) throws ServiceException {
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

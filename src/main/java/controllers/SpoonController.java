package controllers;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.SpoonServiceImpl;

public class SpoonController implements Controller {
    SpoonServiceImpl spoonService = new SpoonServiceImpl();
    /**
     * @throws ControllerException - if error occurs while getting all products
     */
    @Override
    public void getAll() throws ControllerException {
        try {
            spoonService.getAll().forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting all products " + e.getMessage());
        }
    }

    /**
     * @param name - name of the product
     * @throws ControllerException - if error occurs while getting product by name
     */
    @Override
    public void getProductByName(String name) throws ControllerException {
        try {
            spoonService.getProductByName(name).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by name " + e.getMessage());
        }
    }

    /**
     * @param parameter - parameter of the product
     * @throws ControllerException - if error occurs while getting product by parameter
     */
    @Override
    public void getProductByParameter(Parameter parameter) throws ControllerException {
        try {
            spoonService.getProductByParameter(parameter).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by parameter " + e.getMessage());
        }
    }

    /**
     * @param price - price of the product
     * @throws ControllerException - if error occurs while getting purchasable products
     */
    @Override
    public void getPurchasableProducts(int price) throws ControllerException {
        try {
            spoonService.getPurchasableProducts(price).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting purchasable products " + e.getMessage());
        }
    }
}

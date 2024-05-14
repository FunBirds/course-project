package controllers;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.PlateServiceImpl;

public class PlateController implements Controller {
    PlateServiceImpl plateService = new PlateServiceImpl();


    /**
     * @throws ControllerException - if error occurs while getting all products
     */
    @Override
    public void getAll() throws ControllerException {
        try {
            plateService.getAll().forEach(System.out::println);
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
            plateService.getProductByName(name).forEach(System.out::println);
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
            System.out.println(plateService.getProductByParameter(parameter));
//            plateService.getProductByParameter(parameter).forEach(System.out::println);
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
            plateService.getPurchasableProducts(price).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting purchasable products " + e.getMessage());
        }
    }
}

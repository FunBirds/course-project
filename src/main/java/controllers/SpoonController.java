package controllers;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.SpoonServiceImpl;

/**
 * The SpoonController class implements the Controller interface and provides the functionality for managing spoons.
 * It uses the SpoonServiceImpl class to interact with the service layer of the application.
 * Each method can throw a ControllerException if something goes wrong during its execution.
 */
public class SpoonController implements Controller {
    // The service used to interact with the spoons
    SpoonServiceImpl spoonService = new SpoonServiceImpl();

    /**
     * The getAll method retrieves all spoons.
     * It uses the SpoonServiceImpl to get all spoons and then prints them.
     * @throws ControllerException If an error occurs during the operation
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
     * The getProductByName method retrieves a spoon by its name.
     * It uses the SpoonServiceImpl to get the spoon and then prints it.
     * @param name The name of the spoon to retrieve
     * @throws ControllerException If an error occurs during the operation
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
     * The getProductByParameter method retrieves a spoon by a given parameter.
     * It uses the SpoonServiceImpl to get the spoon and then prints it.
     * @param parameter The parameter to use when retrieving the spoon
     * @throws ControllerException If an error occurs during the operation
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
     * The getPurchasableProducts method retrieves all spoons that can be purchased within a certain price range.
     * It uses the SpoonServiceImpl to get the spoons and then prints them.
     * @param price The maximum price of the spoons to retrieve
     * @throws ControllerException If an error occurs during the operation
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
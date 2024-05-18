package controller;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.CupServiceImpl;

/**
 * The CupController class implements the Controller interface and provides the functionality for managing cups.
 * It uses the CupServiceImpl class to interact with the service layer of the application.
 * Each method can throw a ControllerException if something goes wrong during its execution.
 */
public class CupController implements Controller {
    // The service used to interact with the cups
    CupServiceImpl cupService = new CupServiceImpl();

    /**
     * The getAll method retrieves all cups.
     * It uses the CupServiceImpl to get all cups and then prints them.
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getAll() throws ControllerException {
        try {
            cupService.getAll().forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting all products " + e.getMessage());
        }
    }

    /**
     * The getProductByName method retrieves a cup by its name.
     * It uses the CupServiceImpl to get the cup and then prints it.
     * @param name The name of the cup to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getProductByName(String name) throws ControllerException {
        try {
            cupService.getProductByName(name).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by name " + e.getMessage());
        }
    }

    /**
     * The getProductByParameter method retrieves a cup by a given parameter.
     * It uses the CupServiceImpl to get the cup and then prints it.
     * @param parameter The parameter to use when retrieving the cup
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getProductByParameter(Parameter parameter) throws ControllerException {
        try {
            cupService.getProductByParameter(parameter).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by parameter " + e.getMessage());
        }
    }

    /**
     * The getPurchasableProducts method retrieves all cups that can be purchased within a certain price range.
     * It uses the CupServiceImpl to get the cups and then prints them.
     * @param price The maximum price of the cups to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getPurchasableProducts(int price) throws ControllerException {
        try {
            cupService.getPurchasableProducts(price).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting purchasable products " + e.getMessage());
        }
    }
}
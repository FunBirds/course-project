package controller;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.PotServiceImpl;

/**
 * The PotController class implements the Controller interface and provides the functionality for managing pots.
 * It uses the PotServiceImpl class to interact with the service layer of the application.
 * Each method can throw a ControllerException if something goes wrong during its execution.
 */
public class PotController implements Controller {
    // The service used to interact with the pots
    PotServiceImpl potService = new PotServiceImpl();

    /**
     * The getAll method retrieves all pots.
     * It uses the PotServiceImpl to get all pots and then prints them.
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getAll() throws ControllerException {
        try {
            potService.getAll().forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting all products " + e.getMessage());
        }
    }

    /**
     * The getProductByName method retrieves a pot by its name.
     * It uses the PotServiceImpl to get the pot and then prints it.
     * @param name The name of the pot to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getProductByName(String name) throws ControllerException {
        try {
            potService.getProductByName(name).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by name " + e.getMessage());
        }
    }

    /**
     * The getProductByParameter method retrieves a pot by a given parameter.
     * It uses the PotServiceImpl to get the pot and then prints it.
     * @param parameter The parameter to use when retrieving the pot
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getProductByParameter(Parameter parameter) throws ControllerException {
        try {
            potService.getProductByParameter(parameter).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by parameter " + e.getMessage());
        }
    }

    /**
     * The getPurchasableProducts method retrieves all pots that can be purchased within a certain price range.
     * It uses the PotServiceImpl to get the pots and then prints them.
     * @param price The maximum price of the pots to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getPurchasableProducts(int price) throws ControllerException {
        try {
            potService.getPurchasableProducts(price).forEach(System.out::println);
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting purchasable products " + e.getMessage());
        }
    }
}
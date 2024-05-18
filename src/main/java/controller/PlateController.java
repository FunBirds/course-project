package controller;

import dao.criteria.Parameter;
import service.ServiceException;
import service.impl.PlateServiceImpl;

/**
 * The PlateController class implements the Controller interface and provides the functionality for managing plates.
 * It uses the PlateServiceImpl class to interact with the service layer of the application.
 * Each method can throw a ControllerException if something goes wrong during its execution.
 */
public class PlateController implements Controller {
    // The service used to interact with the plates
    PlateServiceImpl plateService = new PlateServiceImpl();

    /**
     * The getAll method retrieves all plates.
     * It uses the PlateServiceImpl to get all plates and then prints them.
     * @throws ControllerException If an error occurs during the operation
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
     * The getProductByName method retrieves a plate by its name.
     * It uses the PlateServiceImpl to get the plate and then prints it.
     * @param name The name of the plate to retrieve
     * @throws ControllerException If an error occurs during the operation
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
     * The getProductByParameter method retrieves a plate by a given parameter.
     * It uses the PlateServiceImpl to get the plate and then prints it.
     * @param parameter The parameter to use when retrieving the plate
     * @throws ControllerException If an error occurs during the operation
     */
    @Override
    public void getProductByParameter(Parameter parameter) throws ControllerException {
        try {
            System.out.println(plateService.getProductByParameter(parameter));
        } catch (ServiceException e) {
            throw new ControllerException("Something went wrong while getting product by parameter " + e.getMessage());
        }
    }

    /**
     * The getPurchasableProducts method retrieves all plates that can be purchased within a certain price range.
     * It uses the PlateServiceImpl to get the plates and then prints them.
     * @param price The maximum price of the plates to retrieve
     * @throws ControllerException If an error occurs during the operation
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
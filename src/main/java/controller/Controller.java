package controller;

import dao.criteria.Parameter;

/**
 * The Controller interface defines the operations that a controller in the application should support.
 * These operations include getting all products, getting a product by its name, getting a product by a parameter, and getting purchasable products within a certain price range.
 * Each operation can throw a ControllerException if something goes wrong during its execution.
 */
public interface Controller {
    /**
     * The getAll method retrieves all products.
     * @throws ControllerException If an error occurs during the operation
     */
    void getAll() throws ControllerException;

    /**
     * The getProductByName method retrieves a product by its name.
     * @param name The name of the product to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    void getProductByName(String name) throws ControllerException;

    /**
     * The getProductByParameter method retrieves a product by a given parameter.
     * @param parameter The parameter to use when retrieving the product
     * @throws ControllerException If an error occurs during the operation
     */
    void getProductByParameter(Parameter parameter) throws ControllerException;

    /**
     * The getPurchasableProducts method retrieves all products that can be purchased within a certain price range.
     * @param price The maximum price of the products to retrieve
     * @throws ControllerException If an error occurs during the operation
     */
    void getPurchasableProducts(int price) throws ControllerException;
}
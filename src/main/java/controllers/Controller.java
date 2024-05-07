package controllers;

import dao.criteria.Parameter;

public interface Controller {
    void getAll() throws ControllerException;
    void getProductByName(String name) throws ControllerException;
    void getProductByParameter(Parameter parameter) throws ControllerException;
    void getPurchasableProducts(int price) throws ControllerException;
}
package service;

import entity.Tableware;

import java.util.List;

public interface Purchasable<T extends Tableware<T>> {
    List<T> getPurchasableProducts(int price) throws ServiceException;
}

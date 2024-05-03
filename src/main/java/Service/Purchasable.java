package Service;

import EntityLayer.Tableware;
import Exceptions.ServiceException;

import java.util.List;

public interface Purchasable<T extends Tableware<T>> {
    List<T> getPurchasableProducts(int price) throws ServiceException;
}

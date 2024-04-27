package Service.impl;

import Dao.CupDao;
import EntityLayer.Cup;
import Service.CupService;
import java.util.*;
import java.util.stream.Collectors;

public class CupServiceImpl implements CupService {
    private List<Cup> cups;
    private final CupDao cupDaoImpl;

    public CupServiceImpl(CupDao cupDaoImpl) {
        this.cupDaoImpl = cupDaoImpl;
    }

    public void setProducts() {
        cups = cupDaoImpl.all();
    }

    private void sortProducts() {
       Collections.sort(cups);
    }
    /**
     * @param price
     * @return
     */
    @Override
    public List<Cup> getPurchasableProducts(int price) {
        setProducts();
        sortProducts();
        return cups
                .stream()
                .filter(e -> e.getPrice() <= price)
                .collect(Collectors.toList());
    }

    /**
     * @return List<Cup>
     */
    @Override
    public List<Cup> getSortedProducts() {
        setProducts();
        sortProducts();
        return cups;
    }

    /**
     * @param name
     */
    @Override
    public List<Cup> getProductsByName(String name) {
        setProducts();
        sortProducts();
        return cups
                .stream()
                .filter(e -> e.getName().contains(name))
                .collect(Collectors.toList());
    }
}

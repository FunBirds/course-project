package Dao;

import EntityLayer.Spoon;

public class SpoonDao extends AbstractDao<Spoon> {
    public SpoonDao() {
        super("spoon.csv");
    }

    @Override
    protected Spoon parse(String[] product) {
        return new Spoon()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setType(product[4])
                .setColor(product[5]);
    }
}

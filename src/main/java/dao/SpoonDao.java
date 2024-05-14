package dao;

import entity.Spoon;

public class SpoonDao extends AbstractDao<Spoon> {
    public SpoonDao() {
        super("spoon.csv");
    }

    @Override
    protected Spoon parse(String[] product) {
        if (product.length < 6) {
            throw new RuntimeException("[SPOON] Product array does not have enough elements. Expected at least 6 elements, but got " + product.length);
        }
        try {
            return new Spoon()
                    .setName(product[0])
                    .setPrice(Double.parseDouble(product[1]))
                    .setMaterial(product[2])
                    .setQuantity(Integer.parseInt(product[3]))
                    .setType(product[4])
                    .setColor(product[5]);
        } catch (Exception e) {
           throw new RuntimeException("Error while parsing spoon" + e.getMessage());
        }
    }
}

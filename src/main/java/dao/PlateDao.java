package dao;

import entity.Plate;

public class PlateDao extends AbstractDao<Plate> {
    public PlateDao() {
        super("plate.csv");
    }

    @Override
    protected Plate parse(String[] product) {
        return new Plate()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setShape(product[4])
                .setColor(product[5]);
    }
}

package Dao;

import EntityLayer.Cup;

public class CupDao extends AbstractDao<Cup> {

    public CupDao() {
        super("cup.csv");
    }

    @Override
    protected Cup parse(String[] product) {
        try {
            return new Cup()
                    .setName(product[0])
                    .setPrice(Double.parseDouble(product[1]))
                    .setMaterial(product[2])
                    .setQuantity(Integer.parseInt(product[3]))
                    .setSize(product[4])
                    .setColor(product[5])
                    .setVolume(Double.parseDouble(product[6]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid product data: " + String.join(", ", product), e);
        }
    }
}

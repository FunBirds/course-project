package dao;

import entity.Pot;

import java.util.Arrays;

public class PotDao extends AbstractDao<Pot> {
        public PotDao() {
            super("pot.csv");
        }

        @Override
        protected Pot parse(String[] product) {
            System.out.println(Arrays.toString(product));
            if (product.length < 6) {
                throw new RuntimeException("[POT] Product array does not have enough elements. Expected at least 6 elements, but got " + product.length + "\n elements" + product.toString());
            }
            try {
                return new Pot()
                        .setName(product[0])
                        .setPrice(Double.parseDouble(product[1]))
                        .setMaterial(product[2])
                        .setQuantity(Integer.parseInt(product[3]))
                        .setType(product[4])
                        .setColor(product[5]);
            } catch (Exception e) {
                throw new RuntimeException("Error while parsing pot" + e.getMessage());
            }
        }
}

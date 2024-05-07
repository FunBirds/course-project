package dao;

import entity.Pot;

public class PotDao extends AbstractDao<Pot> {
        public PotDao() {
            super("pot.csv");
        }

        @Override
        protected Pot parse(String[] product) {
            return new Pot()
                    .setName(product[0])
                    .setPrice(Double.parseDouble(product[1]))
                    .setMaterial(product[2])
                    .setQuantity(Integer.parseInt(product[3]))
                    .setType(product[4])
                    .setColor(product[5]);
        }
}

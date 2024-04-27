package Dao;

import Dao.searchcreteria.AbstractDao;
import EntityLayer.Pot;

public class PotDao extends AbstractDao<Pot> {
        public PotDao() {
            super("resources/pot.csv");
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

package dao;

import entity.Pot;
import java.util.Arrays;

/**
 * This class represents a Data Access Object (DAO) for Pot.
 * It extends the AbstractDao class and provides an implementation for the parse method.
 */
public class PotDao extends AbstractDao<Pot> {

    /**
     * Constructs a new PotDao.
     * The CSV file used is "pot.csv".
     */
    public PotDao() {
        super("pot.csv");
    }

    /**
     * Parses a CSV line into a Pot object.
     * The CSV line is expected to have the following format:
     * name,price,material,quantity,type,color
     * If the CSV line does not have enough elements, a RuntimeException is thrown.
     * @param product The CSV line to parse.
     * @return The parsed Pot object.
     * @throws RuntimeException If the CSV line is not in the expected format or an error occurs while parsing.
     */
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
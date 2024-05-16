package dao;

import entity.Spoon;

/**
 * This class represents a Data Access Object (DAO) for Spoon.
 * It extends the AbstractDao class and provides an implementation for the parse method.
 */
public class SpoonDao extends AbstractDao<Spoon> {

    /**
     * Constructs a new SpoonDao.
     * The CSV file used is "spoon.csv".
     */
    public SpoonDao() {
        super("spoon.csv");
    }

    /**
     * Parses a CSV line into a Spoon object.
     * The CSV line is expected to have the following format:
     * name,price,material,quantity,type,color
     * If an error occurs while parsing, a RuntimeException is thrown.
     * @param product The CSV line to parse.
     * @return The parsed Spoon object.
     * @throws RuntimeException If an error occurs while parsing the CSV line.
     */
    @Override
    protected Spoon parse(String[] product) {
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
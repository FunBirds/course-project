package dao;

import entity.Cup;

/**
 * This class represents a Data Access Object (DAO) for Cup.
 * It extends the AbstractDao class and provides an implementation for the parse method.
 */
public class CupDao extends AbstractDao<Cup> {

    /**
     * Constructs a new CupDao.
     * The CSV file used is "cup.csv".
     */
    public CupDao() {
        super("cup.csv");
    }

    /**
     * Parses a CSV line into a Cup object.
     * The CSV line is expected to have the following format:
     * name,price,material,quantity,color,size,volume
     * @param product The CSV line to parse.
     * @return The parsed Cup object.
     * @throws IllegalArgumentException If the CSV line is not in the expected format.
     */
    @Override
    protected Cup parse(String[] product) {
        try {
            return new Cup()
                    .setName(product[0])
                    .setPrice(Double.parseDouble(product[1]))
                    .setMaterial(product[2])
                    .setQuantity(Integer.parseInt(product[3]))
                    .setColor(product[4])
                    .setSize(product[5])
                    .setVolume(Double.parseDouble(product[6]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid product data: " + String.join(", ", product), e);
        }
    }
}
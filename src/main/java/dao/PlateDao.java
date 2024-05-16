package dao;

import entity.Plate;

/**
 * This class represents a Data Access Object (DAO) for Plate.
 * It extends the AbstractDao class and provides an implementation for the parse method.
 */
public class PlateDao extends AbstractDao<Plate> {

    /**
     * Constructs a new PlateDao.
     * The CSV file used is "plate.csv".
     */
    public PlateDao() {
        super("plate.csv");
    }

    /**
     * Parses a CSV line into a Plate object.
     * The CSV line is expected to have the following format:
     * name,price,material,quantity,shape,color
     * @param product The CSV line to parse.
     * @return The parsed Plate object.
     * @throws NumberFormatException If the CSV line is not in the expected format.
     */
    @Override
    protected Plate parse(String[] product) {
        try {
            return new Plate()
                    .setName(product[0])
                    .setPrice(Double.parseDouble(product[1]))
                    .setMaterial(product[2])
                    .setQuantity(Integer.parseInt(product[3]))
                    .setShape(product[4])
                    .setColor(product[5]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error parsing plate");
        }
    }
}
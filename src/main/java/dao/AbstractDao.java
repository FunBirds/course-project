package dao;

import dao.criteria.SearchCriteria;
import entity.Tableware;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class represents a Data Access Object (DAO) for Tableware.
 * It provides methods to find Tableware based on certain criteria and to find all Tableware.
 * It also defines an abstract method to parse a CSV line into a Tableware object.
 */
public abstract class AbstractDao<A extends Tableware<A>> implements TablewareDao<A> {
    private final Path csvPath;

    /**
     * Constructs a new AbstractDao with the specified CSV file path.
     * @param path The path to the CSV file.
     * @throws IllegalArgumentException If the CSV file is not found.
     */
    protected AbstractDao(String path) {
        try {
            URL resource = getClass().getClassLoader().getResource(path);
            if (resource == null) {
                throw new IllegalArgumentException("No CSV file is found: " + path);
            }
            csvPath = Path.of(resource.toURI());
        } catch (SecurityException | URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Finds and returns a list of Tableware that match the specified criteria.
     * @param criteria The criteria to match.
     * @return A list of Tableware that match the criteria.
     * @throws DaoException If an error occurs while finding the Tableware.
     */
    @Override
    public List<A> find(SearchCriteria<A> criteria) throws DaoException {
        try (BufferedReader in = Files.newBufferedReader(csvPath)){
            in.readLine();
            String line;
            List<A> appliances = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                String[] split = line.split(",");
                A appliance = parse(split);
                if (criteria.test(appliance)) {
                    appliances.add(appliance);
                }
            }
            return appliances;
        } catch (IOException e) {
            throw new DaoException("Something went wrong while finding" + e.getMessage());
        }
    }

    /**
     * Finds and returns a list of all Tableware.
     * @return A list of all Tableware.
     * @throws DaoException If an error occurs while finding the Tableware.
     */
    @Override
    public List<A> findAll() throws DaoException {
        try (BufferedReader in = Files.newBufferedReader(csvPath)){
            in.readLine();
            String line;
            List<A> appliances = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                String[] split = line.split(",");
                A appliance = parse(split);
                appliances.add(appliance);
            }
            return appliances;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    /**
     * Parses a CSV line into a Tableware object.
     * This method is abstract and must be implemented by subclasses.
     * @param csvLine The CSV line to parse.
     * @return The parsed Tableware object.
     * @throws DaoException If an error occurs while parsing the CSV line.
     */
    protected abstract A parse(String[] csvLine) throws DaoException;
}
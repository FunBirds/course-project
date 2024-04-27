package Dao;

import Dao.searchcriteria.SearchCriteria;
import EntityLayer.Tableware;
import Exceptions.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<A extends Tableware<A>> implements TablewareDao<A> {
    private final Path csvPath;

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
            throw new DaoException(e.getMessage());
        }
    }
    protected abstract A parse(String[] csvLine) throws DaoException;
}

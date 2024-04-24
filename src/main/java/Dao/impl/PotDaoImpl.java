package Dao.impl;

import Dao.PotDao;
import EntityLayer.Pot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class PotDaoImpl implements PotDao {
    private String path = "resources/pot.csv";
    /**
     * List of plates
     */
    private List<Pot> pots;
    private final String DELIMITER = ",";

    public PotDaoImpl(){}

    public PotDaoImpl(String path){
        this.path = path;
    }

    /*
      Read the cvs file
     */
    @Override
    public List<Pot> all() {
        try {
            pots = new BufferedReader(new FileReader(path))
                    .lines()
                    .skip(1)
                    .map(e -> createCup(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        return pots;
    }

    private Pot createCup(String[] product) {
        return new Pot()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setType(product[4])
                .setColor(product[5]);

    }
}

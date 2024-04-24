package Dao.impl;

import Dao.PlateDao;
import EntityLayer.Plate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class PlateDaoImpl implements PlateDao {
    private String path = "resources/plate.csv";
    /**
     * List of plates
     */
    private List<Plate> plates;
    private final String DELIMITER = ",";

    public PlateDaoImpl(){}

    public PlateDaoImpl(String path){
        this.path = path;
    }

    /*
      Read the cvs file
     */
    @Override
    public List<Plate> all() {
        try {
            plates = new BufferedReader(new FileReader(path))
                    .lines()
                    .skip(1)
                    .map(e -> createCup(e.split(DELIMITER)))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        return plates;
    }

    private Plate createCup(String[] product) {
        return new Plate()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setShape(product[4])
                .setColor(product[5]);

    }
}

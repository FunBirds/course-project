package Dao.impl;

import Dao.SpoonDao;
import EntityLayer.Spoon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class SpoonDaoImpl {
    private String path = "resources/spoon.csv";
    /**
     * List of products
     */
    private List<Spoon> spoons;
    private final String DELIMITER = ",";


    public SpoonDaoImpl(String path){
        this.path = path;
    }

    /*
      Read the cvs file
     */
//    @Override
//    public List<Spoon> all() {
//        try {
//            spoons = new BufferedReader(new FileReader(path))
//                    .lines()
//                    .skip(1)
//                    .map(e -> createSpoon(e.split(DELIMITER)))
//                    .collect(Collectors.toList());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("File not found");
//        }
//        return spoons;
//    }

    private Spoon createSpoon(String[] product) {
        return new Spoon()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setType(product[4])
                .setColor(product[5]);

    }
}

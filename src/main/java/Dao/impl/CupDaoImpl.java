package Dao.impl;

import Dao.CupDao;
import EntityLayer.Cup;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class CupDaoImpl {
    private String path = "resources/cup.csv";
    /**
     * List of cups
     */
    private List<Cup> cups;
    private final String DELIMITER = ",";

    public CupDaoImpl(){}

    public CupDaoImpl(String path){
        this.path = path;
    }

    /*
      Read the cvs file
     */
//    @Override
//    public List<Cup> all() {
//        try {
//            cups = new BufferedReader(new FileReader(path))
//                    .lines()
//                    .skip(1)
//                    .map(e -> createCup(e.split(DELIMITER)))
//                    .collect(Collectors.toList());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("File not found");
//        }
//        return cups;
//    }

    private Cup createCup(String[] product) {
        return new Cup()
                .setName(product[0])
                .setPrice(Double.parseDouble(product[1]))
                .setMaterial(product[2])
                .setQuantity(Integer.parseInt(product[3]))
                .setSize(product[4])
                .setColor(product[5])
                .setVolume(Double.parseDouble(product[6]));
    }

}

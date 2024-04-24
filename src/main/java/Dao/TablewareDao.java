package Dao;

import EntityLayer.Tableware;

import java.util.List;

public interface TablewareDao<T extends Tableware<T>>  {
    List<T> all();
}

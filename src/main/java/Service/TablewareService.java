package Service;

import EntityLayer.Tableware;

import java.util.List;

public interface TablewareService<T extends Tableware<T>>{
    List<T> getProductsByName(String name);
}

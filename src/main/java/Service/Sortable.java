package Service;

import EntityLayer.Tableware;

import java.util.List;

public interface Sortable<T extends Tableware<T>> {
    List<T> getSortedProducts();
}

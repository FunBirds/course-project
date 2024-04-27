package Dao.searchcriteria;

import EntityLayer.Tableware;

public interface Parameter <A extends Tableware<A>>{
    boolean test(A appliance);
}

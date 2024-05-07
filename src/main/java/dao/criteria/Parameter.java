package dao.criteria;

import entity.Tableware;

public interface Parameter <A extends Tableware<A>>{
    boolean test(A appliance);
}

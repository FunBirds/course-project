package Dao.searchcreteria;

import EntityLayer.Tableware;

public interface SearchCriteria <A extends Tableware<A>>{
    Class<A> getApplianceType();
    <P extends Parameter<A>> SearchCriteria<A> add(P parameter);
    boolean test(A appliance);
}

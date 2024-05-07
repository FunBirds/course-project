package dao.criteria;

import entity.Tableware;

public interface SearchCriteria <A extends Tableware<A>>{
    Class<A> getTablewareType();

    <P extends Parameter<A>> SearchCriteria<A> addParameter(P parameter);

    boolean test(A appliance);
}

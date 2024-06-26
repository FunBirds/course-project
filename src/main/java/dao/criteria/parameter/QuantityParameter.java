package dao.criteria.parameter;

import dao.criteria.Parameter;
import entity.Tableware;

public record QuantityParameter <A extends Tableware<A>>(Range<Integer> range) implements Parameter<A> {
    public QuantityParameter {
        if (range.from() < 0L) {
            throw new IllegalArgumentException("Price can't be less than 0, but was " +
                    range.from());
        }
    }

    @Override
    public boolean test(A appliance) {
        return range.isIn(appliance.getQuantity());
    }
}

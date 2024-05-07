package dao;

import entity.*;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends Tableware<A>> TablewareDao<A> getTablewareDAO(Class<A> tablewareClass) {
        if (Cup.class.equals(tablewareClass)) {
            return (TablewareDao<A>) new CupDao();
        }

        if (Spoon.class.equals(tablewareClass)) {
            return (TablewareDao<A>) new SpoonDao();
        }

        if (Pot.class.equals(tablewareClass)) {
            return (TablewareDao<A>) new PotDao();
        }

        if (Plate.class.equals(tablewareClass)) {
            return (TablewareDao<A>) new PlateDao();
        }
        return null;
    }
}

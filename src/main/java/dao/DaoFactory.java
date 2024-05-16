package dao;

import entity.*;

/**
 * This class represents a factory for creating Data Access Objects (DAOs) for different types of Tableware.
 * It is implemented as a singleton, meaning there is only one instance of this class in the application.
 */
public enum DaoFactory {
    INSTANCE;

    /**
     * Returns a TablewareDao for the specified type of Tableware.
     * The type of Tableware is specified by the class object passed as a parameter.
     * If the class object does not match any known type of Tableware, this method returns null.
     * @param tablewareClass The class object of the type of Tableware for which a DAO is to be returned.
     * @return A TablewareDao for the specified type of Tableware, or null if the type is not known.
     */
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
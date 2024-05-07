package dao;

import entity.Cup;
import entity.Tableware;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAOFactoryTest {
    @Test
    public void shouldReturnNullWhenUnknownClassIsPassed() {
        class DummyAppliance extends Tableware<DummyAppliance> {}
        TablewareDao<DummyAppliance> dao = DaoFactory.INSTANCE.getTablewareDAO(DummyAppliance.class);
        assertNull(dao);
    }

    @Test
    public void shouldReturnOvenDao() {
        TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class);
        assertNotNull(dao);
        assertTrue(dao instanceof CupDao);
    }
}


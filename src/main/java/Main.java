import dao.DaoException;
import service.ServiceException;
import service.impl.CupServiceImpl;

public class Main {
    public static void main(String[] args) throws DaoException, ServiceException {
        CupServiceImpl cupService = new CupServiceImpl();
        cupService.getProductByName("Stainless Steel Travel Mug").forEach(System.out::println);
//        cupService.getAll().forEach(System.out::println);
//        cupService.getProductByParameter(new NameParameter<>("Stainless Steel Travel Mug")).forEach(System.out::println);
//        TablewareDao<Cup> dao = DaoFactory.INSTANCE.getTablewareDAO(Cup.class)
//        dao.find(criteria).forEach(System.out::println);
//        dao.find(criteria);
//        dao.findAll().forEach(System.out::println);
//        criteria.addParameter(new NameParameter<>("Stainless Steel Travel Mug"));
//        dao.find(criteria).forEach(System.out::println);
    }
}

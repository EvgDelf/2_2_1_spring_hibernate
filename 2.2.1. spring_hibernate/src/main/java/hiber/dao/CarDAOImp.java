package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImp implements CarDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    private CarDAOImp (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add (Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}

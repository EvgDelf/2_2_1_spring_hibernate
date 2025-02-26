package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    private UserDaoImp (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

    @Override
    public List<User> listUsers() {
      Query<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
    }

    @Override
    public void findUser(Car car) {
        String hql = "from User where car.model = :model and car.series = :series";
        Query<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());
        System.out.println(query.uniqueResult().toString());
    }

}

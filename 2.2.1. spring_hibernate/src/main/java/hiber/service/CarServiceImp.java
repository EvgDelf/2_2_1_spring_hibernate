package hiber.service;

import hiber.dao.CarDAO;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarServiceImp implements CarService{

    @Autowired
    CarDAO carDAO;

    @Transactional
    @Override
    public void add(Car car) {
        carDAO.add(car);
    }
}

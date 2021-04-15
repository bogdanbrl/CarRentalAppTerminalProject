package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.Car;

import java.util.List;

/**
 * @author Double "B"
 * @created 22/03/2021 - 7:35 PM
 * @project CarRentalAppTerminalProject
 */
public class CarService {

    private SessionFactory sessionFactory;
    private GenericDao<Car> carServiceGenericDao = new GenericDao<>();

    public CarService() {
        sessionFactory = carServiceGenericDao.getSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public GenericDao<Car> getCarServiceGenericDao() {
        return carServiceGenericDao;
    }




    public void addCar(Car car) {
        carServiceGenericDao.add(car);
    }

    public List<Car> viewCars(Car car) {
        List<Car> carList = carServiceGenericDao.getAll(car);
        return carList;
    }

    public void deleteCar(Car car) {
        carServiceGenericDao.delete(car);
    }

    public void update(Car car) {
        carServiceGenericDao.update(car);
    }

    public Car findById(Car car, String id) {
        Car car1 = carServiceGenericDao.findById(car, id);
        return car1;
    }

    public List<Car> getAllCars(){
        List<Car> cars = carServiceGenericDao.getAll(new Car());
        return cars;
    }

    public List<Car> filterCars(String column, String value) {
        List<Car> carsList = carServiceGenericDao.findByColumn(new Car(), column, value);
        return carsList;
    }

    public List<Car> filterCarsByRentPricePerDay(String column, String value) {
        List<Car> carList = carServiceGenericDao.findByColumnLessOrEqualThanValue(new Car(), column, value);
        return carList;
    }
}

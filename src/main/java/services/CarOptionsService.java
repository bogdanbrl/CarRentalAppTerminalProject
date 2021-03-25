package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.CarOptions;

import java.util.List;

/**
 * @author Double "B"
 * @created 22/03/2021 - 7:35 PM
 * @project CarRentalAppSDAProject
 */
public class CarOptionsService {

    SessionFactory sessionFactory;
    private GenericDao<CarOptions> carOptionsGenericDao = new GenericDao<>();

    public void addCarOptions(CarOptions carOptions){
        carOptionsGenericDao.add(carOptions);
    }

    public List<CarOptions> viewCarOptions(CarOptions carOptions){
        List<CarOptions> carOptionsList = carOptionsGenericDao.getAll(carOptions);
        return carOptionsList;
    }

    public void deleteCarOptions(CarOptions carOptions){
        carOptionsGenericDao.delete(carOptions);
    }

    public CarOptions findById(CarOptions carOptions, int id){
        CarOptions carOptions1 = carOptionsGenericDao.findById(carOptions, id);
        return carOptions1;
    }
}

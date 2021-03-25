package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.CarHistory;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Double "B"
 * @created 22/03/2021 - 7:35 PM
 * @project CarRentalAppSDAProject
 */
public class CarHistoryService {

    SessionFactory sessionFactory;
    private GenericDao<CarHistory> carHistoryGenericDao = new GenericDao<>();

    public void addHistoryToCar(CarHistory carHistory){
        carHistoryGenericDao.add(carHistory);
    }

    public List<CarHistory> viewCarHistories(CarHistory carHistory){
        List<CarHistory> carHistories = carHistoryGenericDao.getAll(carHistory);
        return carHistories;
    }

    public void deleteCarHistory(CarHistory carHistory){
        carHistoryGenericDao.delete(carHistory);
    }

    public void updateCarHistory(CarHistory carHistory){
        carHistoryGenericDao.update(carHistory);
    }

    public CarHistory findById(CarHistory carHistory, int id){
        CarHistory carHistory1 = carHistoryGenericDao.findById(carHistory,id);
        return carHistory1;
    }

    public List<CarHistory> findByColumn(String column, String value) {
        List<CarHistory> carHistories = carHistoryGenericDao.findByColumn(new CarHistory(), column, value);
        return carHistories;
    }

    public List<CarHistory> showFullHistoryOfCars(){
        List<CarHistory> carHistories = carHistoryGenericDao.getAll(new CarHistory());
        return carHistories;
    }

    public List<CarHistory> searchByPeriod(LocalDate startDate, LocalDate endDate){
        List<CarHistory> carHistories = carHistoryGenericDao.searchByPeriodOrderedByVIN(new CarHistory(), startDate, endDate);
        return carHistories;
    }


}

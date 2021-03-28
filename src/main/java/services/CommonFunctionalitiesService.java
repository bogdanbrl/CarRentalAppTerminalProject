package services;

import persistence.model.Car;

import java.util.List;

/**
 * @author Double "B"
 * @created 28/03/2021 - 10:07 AM
 * @project CarRentalAppTerminalProject
 */
public class CommonFunctionalitiesService {

    public List<Car> filterCars(String column, String value){
        CarService carService = new CarService();
        List<Car> cars = carService.filterCars(column, value);
        return cars;
    }
}

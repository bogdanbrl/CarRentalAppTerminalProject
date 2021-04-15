package services;

import persistence.model.Car;

import java.util.List;

/**
 * @author Double "B"
 * @created 15/04/2021 - 12:59 PM
 * @project CarRentalAppTerminalProject
 */
public class CommonFunctionalitiesService {

    private CarService carService = new CarService();

    public List<Car> filterCars(String column, String value) {
        carService = new CarService();
        List<Car> carList = carService.filterCars(column, value);

        return carList;
    }

    public List<Car> filterCarsLessOrEqualToValue(String column, String value) {
        carService = new CarService();
        List<Car> carList = carService.filterCarsByRentPricePerDay(column, value);

        return carList;
    }
}

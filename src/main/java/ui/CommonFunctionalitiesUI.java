package ui;

import persistence.model.Car;
import persistence.model.enums.CarClass;
import persistence.model.enums.CarType;
import persistence.model.enums.CheckEnums;
import persistence.model.enums.EngineType;
import services.CommonFunctionalitiesService;

import java.util.List;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 15/04/2021 - 1:02 PM
 * @project CarRentalAppTerminalProject
 */


public class CommonFunctionalitiesUI {

    Scanner intScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    CommonFunctionalitiesService commonFunctionalitiesService = new CommonFunctionalitiesService();

    public void filterOptionChoice() {
        System.out.println("\nFilter cars by: \n");
        System.out.println("press 1 for brand");
        System.out.println("press 2 for engine type\n\t\tGASOLINE\n\t\tDIESEL\n\t\tHYBRID\n\t\tELECTRIC");
        System.out.println("press 3 for car class\n\t\tLUXURY\n\t\tMEDIUM\n\t\tECONOMY");
        System.out.println("press 4 for rent price");
        System.out.println("press 5 for car type\n\t\tSEDAN, COUPE, SPORTS_CAR\n\t\tSTATION_WAGON, HATCHBACK, CONVERTIBLE\n\t\tSPORT_UTILITY_VEHICLE, " +
                "MINIVAN, PICKUP");

        while (!intScanner.hasNextInt()) {
            System.out.println("Insert a valid choice");
            intScanner.next();
        }

        int choice = intScanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Please type car brand: ");
                String brand = stringScanner.next();
                List<Car> carList = commonFunctionalitiesService.filterCars("brand", brand);
                if (carList.isEmpty()) {
                    System.out.println("We dont have " + brand + " for rent!");
                } else {
                    carList.forEach(System.out::println);
                }
                break;
            case 2:
                System.out.println("Please type the engine type: ");
                String stringEngineType = stringScanner.next();
                EngineType engineType = CheckEnums.searchForEngineType(stringEngineType);

                while (engineType == null) {
                    System.out.println("Insert a valid engine type");
                    stringEngineType = stringScanner.next();
                    engineType = CheckEnums.searchForEngineType(stringEngineType);
                }

                List<Car> carList1 = commonFunctionalitiesService.filterCars("engineType", stringEngineType);

                if (carList1.isEmpty()) {
                    System.out.println("Please type a valid engine type!");
                } else {
                    carList1.forEach(System.out::println);
                }
                break;
            case 3:
                System.out.println("Please type the car class");
                String stringCarClass = stringScanner.next();
                CarClass carClass = CheckEnums.searchForCarClass(stringCarClass);

                while (carClass == null) {
                    System.out.println("Insert a valid car class");
                    stringCarClass = stringScanner.next();
                    carClass = CheckEnums.searchForCarClass(stringCarClass);
                }

                List<Car> carList2 = commonFunctionalitiesService.filterCars("carClass", stringCarClass);

                if (carList2.isEmpty()) {
                    System.out.println("Please type a valid car class");
                } else {
                    carList2.forEach(System.out::println);
                }
                break;
            case 4:
                System.out.println("Please insert the max rent price per day");

                while (!intScanner.hasNextDouble()) {
                    System.out.println("Insert a valid price");
                    intScanner.next();
                }
                double rentPrice = intScanner.nextDouble();

                List<Car> carList3 = commonFunctionalitiesService.filterCarsLessOrEqualToValue("rentalPrice", String.valueOf(rentPrice));
                if (carList3.isEmpty()) {
                    System.out.println("We dont have cars for rent with " + rentPrice + " per day!");
                } else {
                    carList3.forEach(System.out::println);
                }
                break;
            case 5:
                System.out.println("Please insert car type:");
                String stringCarType = stringScanner.next();
                CarType carType = CheckEnums.searchForCarType(stringCarType);

                while (carType == null) {
                    System.out.println("Insert a valid car type");
                    stringCarType = stringScanner.next();
                    carType = CheckEnums.searchForCarType(stringCarType);
                }

                List<Car> carList4 = commonFunctionalitiesService.filterCars("carType", stringCarType);

                if (carList4.isEmpty()) {
                    System.out.println("Please type a valid car type");
                } else {
                    carList4.forEach(System.out::println);
                }
                break;
            default:
                filterOptionChoice();
                break;
        }
    }
}

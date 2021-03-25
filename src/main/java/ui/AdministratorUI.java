package ui;

import persistence.model.Car;
import persistence.model.CarOptions;
import persistence.model.enums.CarClass;
import persistence.model.enums.CarType;
import persistence.model.enums.CheckEnums;
import persistence.model.enums.EngineType;
import services.AdministratorService;
import utils.GregorianDateMatcher;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 23/03/2021 - 6:53 PM
 * @project CarRentalAppTerminalProject
 */
public class AdministratorUI {

    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);

    public void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("Press 1 to add new admin account");
        System.out.println("Press 2 to change password");
        System.out.println("Press 3 to see all users");
        System.out.println("Press 4 to remove user");
        System.out.println("Press 5 to show all cars from fleet");
        System.out.println("Press 6 to add car to fleet");
        System.out.println("Press 7 to delete car from fleet");
        System.out.println("Press 8 to show history of a car");
        System.out.println("Press 9 to show rented cars between a given period");
        System.out.println("Press 10 to logout");


        while(!intScanner.hasNextInt()){
            System.out.println("Insert a valid choice");
            intScanner.next();
        }

        int choice = intScanner.nextInt();

        AdministratorService administratorService = new AdministratorService();

        switch (choice){
            case 1: administratorService.addAdministratorAccount();
                break;
            case 2: // @Todo administratorService.changePassword();
                System.out.println("This feature is not available yet. Come back later!");
                break;
            case 3: administratorService.showUsers();
                break;
            case 4:
                System.out.println("Insert username that you want to delete: ");
                String username = stringScanner.next();
                administratorService.removeUser(username);
                break;
            case 5: administratorService.showCarsFromFleet();
                break;
            case 6:
                Car car = insertCarDetails();
                CarOptions carOptions = insertCarOptions();
                administratorService.addCarToFleet(car, carOptions);
                break;
            case 7:
                System.out.println("Insert VIN for the car you want to delete from database");
                String VIN = stringScanner.next();
                administratorService.deleteCarFromFleet(VIN);
                break;
            case 8:
                System.out.println("Insert VIN for the whose history you want to check");
                String VIN2 = stringScanner.next();
                administratorService.showHistoryOfACar(VIN2);
                break;
            case 9:
                LocalDate startDate = getStartDate();
                LocalDate endDate = getEndDate();
                while (startDate.isAfter(endDate)){
                    System.out.println("End date cannot be before start date");
                    endDate=getEndDate();
                }
                administratorService.searchCarHistoryByPeriod(startDate, endDate);
                break;
            case 10: administratorService.logout();
                break;
            default: showMenu();
        }

    }

    private LocalDate getEndDate() {
        GregorianDateMatcher gregorianDateMatcher = new GregorianDateMatcher();
        System.out.println("Enter the date from which the period ends as: 'yyyy-MM-dd'");
        String endDateString = stringScanner.next();

        while(!gregorianDateMatcher.matches(endDateString)){
            System.out.println("Enter a valid date as: 'yyyy-MM-dd'");
            endDateString = stringScanner.next();

        }
        LocalDate endDate = LocalDate.parse(endDateString);
        return endDate;
    }

    private LocalDate getStartDate() {
        GregorianDateMatcher gregorianDateMatcher = new GregorianDateMatcher();

        System.out.println("Enter the date from which the period begins as: 'yyyy-MM-dd'");
        String startDateString = stringScanner.next();
        while(!gregorianDateMatcher.matches(startDateString)){
            System.out.println("Enter a valid date as: 'yyyy-MM-dd'");
            startDateString = stringScanner.next();
        }
        LocalDate startDate = LocalDate.parse(startDateString);
        return startDate;
    }

    private CarOptions insertCarOptions() {
        CarOptions carOptions = new CarOptions();

        System.out.println("Has car automatic gearbox?");
        while(!stringScanner.hasNextBoolean()){
            System.out.println("Insert true or false");
            stringScanner.next();
        }
        boolean hasAutomaticGearBox = stringScanner.nextBoolean();

        System.out.println("Has car navigation?");
        while(!stringScanner.hasNextBoolean()){
            System.out.println("Insert true or false");
            stringScanner.next();
        }
        boolean hasNavigation = stringScanner.nextBoolean();

        System.out.println("Has car heated seats?");
        while(!stringScanner.hasNextBoolean()){
            System.out.println("Insert true or false");
            stringScanner.next();
        }
        boolean hasHeatedSeats = stringScanner.nextBoolean();

        carOptions.setAutomaticGearBox(hasAutomaticGearBox);
        carOptions.setHasHeatedSeats(hasHeatedSeats);
        carOptions.setHasNavigation(hasNavigation);

        return carOptions;
    }

    private Car insertCarDetails() {
        Car car = new Car();

        System.out.println("Insert VIN: ");
        String VIN = stringScanner.next();

        System.out.println("Insert brand: ");
        String brand = stringScanner.next();

        System.out.println("Insert model: ");
        String model = stringScanner.next();

        System.out.println("Insert yearOfProduction: ");
        while(!intScanner.hasNextInt()){
            System.out.println("Insert a valid choice");
            intScanner.next();
        }
        int yearOfProduction = intScanner.nextInt();

        System.out.println("Insert carType: ");
        String str = stringScanner.next();
        CarType carType = CheckEnums.searchForCarType(str);
        while (carType == null){
            System.out.println("Insert a valid car type");
            str = stringScanner.next();
            carType = CheckEnums.searchForCarType(str);
        }

        System.out.println("Insert carClass: ");
        String str2 = stringScanner.next();
        CarClass carClass = CheckEnums.searchForCarClass(str2);
        while (carClass == null){
            System.out.println("Insert a valid car class");
            str2 = stringScanner.next();
            carClass = CheckEnums.searchForCarClass(str2);
        }

        System.out.println("Insert engineType: ");
        String str3 = stringScanner.next();
        EngineType engineType = CheckEnums.searchForEngineType(str3);
        while (engineType == null){
            System.out.println("Insert a valid engine type");
            str3 = stringScanner.next();
            engineType = CheckEnums.searchForEngineType(str3);
        }

        System.out.println("Insert rentalPrice: ");
        while(!intScanner.hasNextDouble()){
            System.out.println("Insert a valid choice");
            intScanner.next();
        }
        double rentalPrice = intScanner.nextDouble();

        car.setVIN(VIN);
        car.setBrand(brand);
        car.setModel(model);
        car.setYearOfProduction(yearOfProduction);
        car.setCarType(carType);
        car.setCarClass(carClass);
        car.setEngineType(engineType);
        car.setRentalPrice(rentalPrice);
        car.setAvailable(true);

        return car;
    }
}

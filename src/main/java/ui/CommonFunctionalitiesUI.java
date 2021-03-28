package ui;

import persistence.model.Car;
import services.CommonFunctionalitiesService;

import java.util.List;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 28/03/2021 - 10:09 AM
 * @project CarRentalAppTerminalProject
 */
public class CommonFunctionalitiesUI {

    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);

    public void filterOptionChoice() {
        System.out.println("Filter cars by: ");
        System.out.println("\t 1: brand");
        System.out.println("\t 2: engine type (GASOLINE,\n" +
                "    \t\tDIESEL,\n" +
                "    \t\tHYBRID,\n" +
                "    \t\tELECTRIC)");
        System.out.println("\t 3: car class (ECONOMY,\n" +
                "    \t\tMEDIUM,\n" +
                "    \t\tLUXURY)");
        System.out.println("\t 4: car type (SEDAN,\n" +
                "    \t\tCOUPE,\n" +
                "    \t\tSPORTS_CAR,\n" +
                "    \t\tSTATION_WAGON,\n" +
                "    \t\tHATCHBACK,\n" +
                "    \t\tCONVERTIBLE,\n" +
                "    \t\tSPORT_UTILITY_VEHICLE,\n" +
                "    \t\tMINIVAN,\n" +
                "    \t\tPICKUP)");
        System.out.println("\t 5: rent price");

        while(!intScanner.hasNextInt()){
            System.out.println("Insert a valid choice");
            intScanner.next();
        }

        int choice = intScanner.nextInt();

        CommonFunctionalitiesService commonFunctionalitiesService = new CommonFunctionalitiesService();

        switch (choice){
            case 1:
                System.out.println("Insert brand:");
                String brand = stringScanner.next();
                List<Car> cars = commonFunctionalitiesService.filterCars("brand", brand);
                if (cars==null || cars.isEmpty()){
                    System.out.println("We don't own this brand");
                    break;
                }
                cars.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Insert engine type:");
                String engineType = stringScanner.next().toUpperCase();

                List<Car> cars2 = commonFunctionalitiesService.filterCars("engineType", engineType);
                if (cars2==null || cars2.isEmpty()){
                    System.out.println("We don't own this engine type");
                    break;
                }
                cars2.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Insert car class:");
                String carClass = stringScanner.next().toUpperCase();

                List<Car> cars3 = commonFunctionalitiesService.filterCars("carClass", carClass);
                if (cars3==null || cars3.isEmpty()){
                    System.out.println("We don't own this car class");
                    break;
                }
                cars3.forEach(System.out::println);
                break;
            case 4:
                System.out.println("Insert car type:");
                String carType = stringScanner.next().toUpperCase();

                List<Car> cars4 = commonFunctionalitiesService.filterCars("carType", carType);
                if (cars4==null || cars4.isEmpty()){
                    System.out.println("We don't own this car type");
                    break;
                }
                cars4.forEach(System.out::println);
                break;
            case 5:
                System.out.println("Insert maximum rent price");

                while (!intScanner.hasNextDouble()){
                    System.out.println("This is not a valid price. Insert maximum price");
                    intScanner.next();
                }
                double rentPrice = intScanner.nextDouble();
                List<Car> cars5 = commonFunctionalitiesService.filterCars("rentalPrice", String.valueOf(rentPrice));
                if (cars5==null || cars5.isEmpty()){
                    System.out.println("We don't own this car type");
                    break;
                }
                cars5.forEach(System.out::println);
                break;
            default: filterOptionChoice();
        }


    }
}

package services;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import persistence.model.Car;
import persistence.model.CarOptions;
import persistence.model.enums.CarClass;
import persistence.model.enums.CarType;
import persistence.model.enums.EngineType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Double "B"
 * @created 22/03/2021 - 8:46 PM
 * @project CarRentalAppTerminalProject
 */
public class CarServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test() {

        CarService carService = new CarService();
        CarOptionsService carOptionsService = new CarOptionsService();
//        Session session = carService.getSessionFactory().openSession();
//        Transaction transaction = session.getTransaction();


        // add car to database
        CarOptions carOptions = new CarOptions(true, true, true);
        carOptionsService.addCarOptions(carOptions);

        Car car = new Car("3795VIN686", "Audi", "A7", 2019, CarType.SPORTS_CAR, CarClass.LUXURY,
                EngineType.DIESEL, 76.00, true);
        car.setCarOptions(carOptions);
        carService.addCar(car);

//        transaction.commit();

    }

    @Test
    public void populateCarTable(){

        List<String[]> carsDetatils = new ArrayList<>();

        carsDetatils.add(new String[]{"Citroen", "C3", "2015", "HATCHBACK", "ECONOMY", "false", "true", "true", "DIESEL", "12.00", "true"});
        carsDetatils.add(new String[]{"Dacia", "Logan", "2018", "SEDAN", "ECONOMY", "false", "true", "false", "GASOLINE", "14.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Fiesta", "2017", "HATCHBACK", "ECONOMY", "true", "true", "true", "DIESEL", "14.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Clio", "2015", "HATCHBACK", "ECONOMY", "true", "true", "true", "DIESEL", "13.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "HATCHBACK", "ECONOMY", "true", "false", "false", "GASOLINE", "13.00", "true"});
        carsDetatils.add(new String[]{"Citroen", "C4", "2019", "HATCHBACK", "ECONOMY", "true", "true", "true", "GASOLINE", "17.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Astra", "2017", "HATCHBACK", "ECONOMY", "true", "false", "false", "GASOLINE", "13.00", "true"});
        carsDetatils.add(new String[]{"Skoda", "Octavia", "2017", "STATION_WAGON", "MEDIUM", "false", "false", "false", "GASOLINE", "21.00", "true"});
        carsDetatils.add(new String[]{"Peugeot", "308", "2015", "STATION_WAGON", "MEDIUM", "true", "false", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Scenic", "2017", "MINIVAN", "MEDIUM", "false", "true", "true", "DIESEL", "21.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Insignia", "2016", "STATION_WAGON", "MEDIUM", "false", "false", "false", "DIESEL", "22.00", "true"});
        carsDetatils.add(new String[]{"Dacia", "Duster", "2020", "SPORT_UTILITY_VEHICLE", "MEDIUM", "false", "true", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Vivaro", "2017", "MINIVAN", "MEDIUM", "false", "false", "false", "DIESEL", "26.00", "true"});
        carsDetatils.add(new String[]{"Citroen", "C3", "2015", "HATCHBACK", "ECONOMY", "false", "true", "true", "DIESEL", "12.00", "true"});
        carsDetatils.add(new String[]{"Dacia", "Logan", "2018", "SEDAN", "ECONOMY", "false", "true", "false", "GASOLINE", "14.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Fiesta", "2017", "HATCHBACK", "ECONOMY", "true", "true", "true", "DIESEL", "14.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Clio", "2015", "HATCHBACK", "ECONOMY", "true", "true", "true", "DIESEL", "13.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "HATCHBACK", "ECONOMY", "true", "false", "false", "GASOLINE", "13.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Astra", "2017", "HATCHBACK", "ECONOMY", "true", "false", "false", "GASOLINE", "13.00", "true"});
        carsDetatils.add(new String[]{"Citroen", "C4", "2019", "HATCHBACK", "ECONOMY", "true", "true", "true", "GASOLINE", "17.00", "true"});
        carsDetatils.add(new String[]{"Skoda", "Octavia", "2017", "STATION_WAGON", "MEDIUM", "false", "false", "false", "GASOLINE", "21.00", "true"});
        carsDetatils.add(new String[]{"Peugeot", "308", "2015", "STATION_WAGON", "MEDIUM", "true", "false", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Scenic", "2017", "MINIVAN", "MEDIUM", "false", "true", "true", "DIESEL", "21.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Insignia", "2015", "STATION_WAGON", "MEDIUM", "false", "false", "false", "DIESEL", "22.00", "true"});
        carsDetatils.add(new String[]{"Dacia", "Duster", "2019", "SPORT_UTILITY_VEHICLE", "MEDIUM", "false", "true", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Vivaro", "2019", "MINIVAN", "MEDIUM", "false", "false", "false", "DIESEL", "26.00", "true"});
        carsDetatils.add(new String[]{"Peugeot", "308", "2013", "STATION_WAGON", "MEDIUM", "true", "false", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Scenic", "2020", "MINIVAN", "MEDIUM", "false", "false", "true", "DIESEL", "21.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Scenic", "2019", "MINIVAN", "MEDIUM", "false", "true", "true", "DIESEL", "21.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Insignia", "2018", "STATION_WAGON", "MEDIUM", "false", "false", "false", "DIESEL", "22.00", "true"});
        carsDetatils.add(new String[]{"Dacia", "Duster", "2019", "SPORT_UTILITY_VEHICLE", "MEDIUM", "false", "true", "true", "DIESEL", "23.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Vivaro", "2015", "MINIVAN", "MEDIUM", "false", "false", "false", "GASOLINE", "26.00", "true"});
        carsDetatils.add(new String[]{"Skoda", "Rapid", "2016", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2015", "HATCHBACK", "MEDIUM", "true", "false", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2016", "SEDAN", "MEDIUM", "true", "false", "true", "GASOLINE", "27.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "27.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2015", "HATCHBACK", "MEDIUM", "false", "false", "false", "DIESEL", "25.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Vivaro", "2015", "MINIVAN", "MEDIUM", "false", "false", "false", "DIESEL", "26.00", "true"});
        carsDetatils.add(new String[]{"Skoda", "Rapid", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2019", "HATCHBACK", "MEDIUM", "true", "false", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2013", "SEDAN", "MEDIUM", "true", "false", "true", "GASOLINE", "27.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2017", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "27.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2017", "HATCHBACK", "MEDIUM", "false", "false", "false", "DIESEL", "25.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Vivaro", "2017", "MINIVAN", "MEDIUM", "false", "false", "false", "DIESEL", "26.00", "true"});
        carsDetatils.add(new String[]{"Skoda", "Rapid", "2019", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2019", "HATCHBACK", "MEDIUM", "true", "false", "false", "DIESEL", "24.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2018", "SEDAN", "MEDIUM", "true", "false", "true", "GASOLINE", "27.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2019", "SEDAN", "MEDIUM", "true", "true", "false", "DIESEL", "27.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2017", "HATCHBACK", "MEDIUM", "false", "false", "false", "GASOLINE", "25.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "GASOLINE", "27.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2018", "HATCHBACK", "MEDIUM", "false", "false", "false", "DIESEL", "25.00", "true"});
        carsDetatils.add(new String[]{"Fiat", "Tipo", "2018", "SEDAN", "MEDIUM", "true", "true", "true", "DIESEL", "27.00", "true"});
        carsDetatils.add(new String[]{"Suzuki", "SX-4", "2018", "SPORT_UTILITY_VEHICLE", "MEDIUM", "false", "false", "false", "DIESEL", "25.00", "true"});
        carsDetatils.add(new String[]{"BMW", "120", "2018", "HATCHBACK", "LUXURY", "true", "true", "true", "DIESEL", "34.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A4", "2017", "SEDAN", "LUXURY", "true", "true", "true", "DIESEL", "35.00", "true"});
        carsDetatils.add(new String[]{"BMW", "320", "2019", "SEDAN", "LUXURY", "true", "true", "true", "DIESEL", "38.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A4", "2017", "SEDAN", "LUXURY", "true", "true", "true", "DIESEL", "41.00", "true"});
        carsDetatils.add(new String[]{"BMW", "740", "2019", "SEDAN", "LUXURY", "true", "true", "true", "GASOLINE", "52.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A8", "2017", "SEDAN", "LUXURY", "true", "true", "true", "GASOLINE", "50.00", "true"});
        carsDetatils.add(new String[]{"Land Rover", "Freeelander", "2018", "SPORT_UTILITY_VEHICLE", "LUXURY", "true", "true", "true", "DIESEL", "55.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Tiguan", "2016", "SPORT_UTILITY_VEHICLE", "LUXURY", "true", "true", "true", "DIESEL", "43.00", "true"});
        carsDetatils.add(new String[]{"Land Rover", "Freeelander", "2017", "SPORT_UTILITY_VEHICLE", "LUXURY", "true", "true", "true", "DIESEL", "55.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Tiguan", "2016", "SPORT_UTILITY_VEHICLE", "LUXURY", "true", "true", "true", "DIESEL", "43.00", "true"});
        carsDetatils.add(new String[]{"BMW", "x5", "2019", "SEDAN", "LUXURY", "false", "true", "true", "GASOLINE", "56.00", "true"});
        carsDetatils.add(new String[]{"Range Rover", "Sport", "2018", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "GASOLINE", "56.00", "true"});
        carsDetatils.add(new String[]{"Audi", "Q5", "2019", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "DIESEL", "55.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "GLB", "2016", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "DIESEL", "56.00", "true"});
        carsDetatils.add(new String[]{"Jeepr", "Renegade", "2017", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "GASOLINE", "55.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "GLB", "2017", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "DIESEL", "56.00", "true"});
        carsDetatils.add(new String[]{"Jeepr", "Renegade", "2017", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "GASOLINE", "55.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Tiguan", "2019", "SPORT_UTILITY_VEHICLE", "LUXURY", "false", "true", "true", "DIESEL", "43.00", "true"});
        carsDetatils.add(new String[]{"BMW", "x5", "2018", "SEDAN", "LUXURY", "true", "true", "true", "GASOLINE", "58.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2015", "HATCHBACK", "MEDIUM", "true", "false", "false", "HYBRID", "24.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2016", "SEDAN", "MEDIUM", "true", "false", "true", "HYBRID", "27.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "HYBRID", "27.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2015", "HATCHBACK", "MEDIUM", "false", "false", "false", "HYBRID", "25.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2017", "HATCHBACK", "MEDIUM", "true", "false", "false", "HYBRID", "26.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2018", "SEDAN", "MEDIUM", "true", "false", "true", "HYBRID", "29.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "HYBRID", "29.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2016", "HATCHBACK", "MEDIUM", "false", "false", "false", "HYBRID", "26.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2018", "HATCHBACK", "MEDIUM", "true", "false", "false", "ELECTRIC", "29.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2018", "SEDAN", "MEDIUM", "true", "false", "true", "ELECTRIC", "32.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2018", "SEDAN", "MEDIUM", "true", "true", "false", "ELECTRIC", "33.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2019", "HATCHBACK", "MEDIUM", "false", "false", "false", "ELECTRIC", "30.00", "true"});
        carsDetatils.add(new String[]{"Volkswagen", "Golf", "2019", "HATCHBACK", "MEDIUM", "true", "false", "false", "ELECTRIC", "34.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A3", "2020", "SEDAN", "MEDIUM", "true", "false", "true", "ELECTRIC", "35.00", "true"});
        carsDetatils.add(new String[]{"Renault", "Megane", "2020", "SEDAN", "MEDIUM", "true", "true", "false", "ELECTRIC", "34.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Focus", "2020", "HATCHBACK", "MEDIUM", "false", "false", "false", "ELECTRIC", "36.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "CLK", "2015", "COUPE", "MEDIUM", "false", "false", "false", "DIESEL", "42.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "CLA", "2015", "COUPE", "LUXURY", "true", "true", "true", "DIESEL", "66.00", "true"});
        carsDetatils.add(new String[]{"Rolls-Royce", "Wraith", "2019", "COUPE", "LUXURY", "true", "true", "true", "DIESEL", "82.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "CLA", "2015", "COUPE", "LUXURY", "true", "true", "true", "ELECTRIC", "73.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A5", "2018", "COUPE", "LUXURY", "true", "true", "true", "HYBRID", "75.00", "true"});
        carsDetatils.add(new String[]{"BMW", "420", "2018", "COUPE", "LUXURY", "true", "true", "true", "ELECTRIC", "80.00", "true"});
        carsDetatils.add(new String[]{"Mercedes", "CLA", "2018", "COUPE", "LUXURY", "true", "true", "true", "ELECTRIC", "73.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A5", "2017", "COUPE", "LUXURY", "true", "true", "true", "HYBRID", "75.00", "true"});
        carsDetatils.add(new String[]{"BMW", "420", "2017", "COUPE", "LUXURY", "true", "true", "true", "ELECTRIC", "80.00", "true"});
        carsDetatils.add(new String[]{"Audi", "A5", "2019", "COUPE", "LUXURY", "true", "true", "true", "HYBRID", "75.00", "true"});
        carsDetatils.add(new String[]{"BMW", "420", "2020", "COUPE", "LUXURY", "true", "true", "true", "ELECTRIC", "80.00", "true"});
        carsDetatils.add(new String[]{"BMW", "Z4", "2018", "CONVERTIBLE", "LUXURY", "false", "true", "true", "DIESEL", "68.00", "true"});
        carsDetatils.add(new String[]{"BMW", "335i", "2017", "CONVERTIBLE", "LUXURY", "false", "true", "true", "DIESEL", "68.00", "true"});
        carsDetatils.add(new String[]{"BMW", "435i", "2018", "CONVERTIBLE", "LUXURY", "false", "true", "true", "DIESEL", "68.00", "true"});
        carsDetatils.add(new String[]{"BMW", "Z4", "2018", "CONVERTIBLE", "LUXURY", "true", "true", "true", "ELECTRIC", "68.00", "true"});
        carsDetatils.add(new String[]{"Opel", "Corsa", "2016", "CONVERTIBLE", "MEDIUM", "true", "true", "true", "DIESEL", "33.00", "true"});
        carsDetatils.add(new String[]{"Volvo", "C70", "2019", "CONVERTIBLE", "MEDIUM", "true", "true", "true", "GASOLINE", "36.00", "true"});
        carsDetatils.add(new String[]{"Peugeot", "206", "2019", "CONVERTIBLE", "MEDIUM", "false", "true", "true", "HYBRID", "39.00", "true"});
        carsDetatils.add(new String[]{"Toyota", "Hilux", "2019", "PICKUP", "LUXURY", "false", "true", "true", "DIESEL", "76.00", "true"});
        carsDetatils.add(new String[]{"Mitsubishi", "L200", "2019", "PICKUP", "MEDIUM", "false", "true", "true", "GASOLINE", "69.00", "true"});
        carsDetatils.add(new String[]{"Ford", "Ranger", "2017", "PICKUP", "LUXURY", "false", "true", "true", "GASOLINE", "88.00", "true"});
        carsDetatils.add(new String[]{"Nissan", "Navara", "2016", "PICKUP", "LUXURY", "false", "true", "true", "HYBRID", "77.00", "true"});

        CarService carService = new CarService();
        CarOptionsService carOptionsService = new CarOptionsService();

        for (int i = 0; i < carsDetatils.size(); i++) {
            CarOptions carOptions = new CarOptions(Boolean.parseBoolean(carsDetatils.get(i)[5]), Boolean.parseBoolean(carsDetatils.get(i)[6]), Boolean.parseBoolean(carsDetatils.get(i)[7]));
            carOptionsService.addCarOptions(carOptions);

            Car car = new Car(generateVIN(), carsDetatils.get(i)[0], carsDetatils.get(i)[1], Integer.parseInt(carsDetatils.get(i)[2]),
                    CarType.valueOf(carsDetatils.get(i)[3]), CarClass.valueOf(carsDetatils.get(i)[4]),
                    EngineType.valueOf(carsDetatils.get(i)[8]), Double.parseDouble(carsDetatils.get(i)[9]), Boolean.parseBoolean(carsDetatils.get(i)[10]));
            car.setCarOptions(carOptions);
            carService.addCar(car);
        }


    }

    private String generateVIN(){

        Supplier<Integer> integerSupplier = () -> (int) (Math.random() * 10000);

        int randomNr1 = (int) ((Math.random() * (99999 - 10000)) + 1000);
        int randomNr2 = (int) ((Math.random() * (9999 - 1000)) + 100);

        //return integerSupplier+"VIN"+integerSupplier;
        return randomNr1+"VIN"+randomNr2;
    }
}
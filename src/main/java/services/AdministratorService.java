package services;

import applicationSession.Login;
import applicationSession.Signup;
import persistence.model.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Double "B"
 * @created 23/03/2021 - 2:12 PM
 * @project CarRentalAppTerminalProject
 */
public class AdministratorService {

    public void logout(){
        Login.getInstance().setUserSession(null);
        System.out.println("Logged out!");
    }

    public void addAdministratorAccount() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Signup signup = new Signup();
        signup.signup();
    }

    //@Todo change password
    public void changePassword(){}

    public void removeUser(String username){
        UserService userService = new UserService();
        User userToRemove = userService.findById(new User(), username);

        if(userToRemove != null){
            /**
             * check if the required user is the default admin account
            this account should not be removed
             */
            if(userToRemove.getAccountType().equals("default")){
                System.out.println("You cannot remove default admin account!");
                return;
            }
            AccountService accountService = new AccountService();
            Account accountToDelete = accountService.findById(new Account(), username);
            accountService.deleteAccount(accountToDelete);
            userService.deleteUser(userToRemove);
            System.out.println("User has been deleted!");
        }else{
            System.out.println("User with username: " + username + " not found!");
        }

    }

    public void showUsers(){
        UserService userService = new UserService();
        AccountService accountService = new AccountService();

        List<User> users = userService.showAllUsers();
        for (User user : users) {
            Account account = accountService.findById(new Account(), user.getUserName());
            System.out.println(account);
        }
    }

    public void showHistoryOfACar(String VIN){
        CarHistoryService carHistoryService = new CarHistoryService();
        String column = "car_id";
        List<CarHistory> carHistories = carHistoryService.findByColumn(column, VIN);
        if(carHistories == null || carHistories.isEmpty()){
            System.out.println("No record found for car with VIN: " + VIN +"!");
            return;
        }
        for (CarHistory carHistory : carHistories) {
            System.out.println(carHistory);
        }
    }

    public void showCarsFromFleet(){
        CarService carService = new CarService();
        List<Car> cars = carService.getAllCars();

        for (Car car : cars){
            System.out.println(car);
        }
    }

    public void addCarToFleet(Car car, CarOptions carOptions){
        CarOptionsService carOptionsService = new CarOptionsService();
        carOptionsService.addCarOptions(carOptions);

        CarService carService = new CarService();
        car.setCarOptions(carOptions);
        carService.addCar(car);

    }

    public void deleteCarFromFleet(String carVIN){
        CarService carService = new CarService();
        Car carToDelete = carService.findById(new Car(), carVIN);

        if(carToDelete == null){
            System.out.println("Car with VIN: "+ carVIN + " not found!");
            System.out.println("Action denied!");
            return;
        }

        carService.deleteCar(carToDelete);

        CarOptionsService carOptionsService = new CarOptionsService();
        carOptionsService.deleteCarOptions(carToDelete.getCarOptions());

        System.out.println("Car entry deleted!");
    }

    public void searchCarHistoryByPeriod(LocalDate startDate, LocalDate endDate){
        CarHistoryService carHistoryService = new CarHistoryService();
        List<CarHistory> carHistories = carHistoryService.searchByPeriod(startDate, endDate);

        for (CarHistory carHistory : carHistories) {
            System.out.println("Car VIN: " + carHistory.getCar().getVIN() + " ");
            System.out.println(carHistory);
        }
    }

}

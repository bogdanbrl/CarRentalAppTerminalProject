package services;

import applicationSession.Login;
import persistence.model.*;
import utils.encryption.PasswordEncryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author Double "B"
 * @created 23/03/2021 - 3:05 PM
 * @project CarRentalAppSDAProject
 */
public class CustomerService {

    public void logout() {
        Login.getInstance().setUserSession(null);
        System.out.println("Logged out!");
    }

    public void changePassword(String newPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        AccountService accountService = new AccountService();
        Account account = accountService.findById(new Account(), Login.getInstance().getUserSession().getUserName());
        account.setPassword(encryptPassword(newPassword));
        accountService.updateAccount(account);
    }

    private String encryptPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.encrypt(password);
    }

    public void deleteAccount() {
        UserService userService = new UserService();
        User userToDelete = userService.findById(new User(), Login.getInstance().getUserSession().getUserName());

        UserHistoryService userHistoryService = new UserHistoryService();
        List<UserHistory> userHistories = userHistoryService.getHistoriesOfUser(userToDelete.getUserName());
        if(userHistories!=null){
            for (UserHistory userHistory : userHistories) {
                if(userHistory.getCurrentRentedCar()!=null){
                    System.out.println("You own one or more cars rented from us. Return them so you can delete the account!");
                    return;
                }
            }
        }
        if(userHistories!=null){
            for (UserHistory userHistory : userHistories) {
                userHistoryService.deleteUserHistory(userHistory);
            }
        }

        AccountService accountService = new AccountService();
        Account account = accountService.findById(new Account(), userToDelete.getUserName());

        accountService.deleteAccount(account);
        userService.deleteUser(userToDelete);

        System.out.println("Account deleted!");
        logout();
    }

    public void showAllCars() {
        CarService carService = new CarService();
        List<Car> cars = carService.getAllCars();

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void rentCar(Car car, LocalDate pickupDate, LocalDate returnDate) {
        CarService carService = new CarService();
        car.setAvailable(false);

        carService.update(car);

        UserHistoryService userHistoryService = new UserHistoryService();
        UserHistory userHistory = new UserHistory();

        String details = "Rented car with details: " + car.toString() + " from " + pickupDate + " until " + returnDate;
        userHistory.setDetails(details);

        User currentUser = Login.getInstance().getUserSession();
        userHistory.setUser(currentUser);

        String VINofCurrentRentedCar = car.getVIN();
        userHistory.setCurrentRentedCar(VINofCurrentRentedCar);

        userHistoryService.addUserHistory(userHistory);

        CarHistoryService carHistoryService = new CarHistoryService();
        CarHistory carHistory = new CarHistory();
        carHistory.setPickupDate(pickupDate);
        carHistory.setRentPricePerDay(car.getRentalPrice());
        String username = currentUser.getUserName();
        carHistory.setRentedToUser(username);
        carHistory.setReturnDate(returnDate);
        carHistory.setCar(car);

        carHistoryService.addHistoryToCar(carHistory);

        long days = calculateRentPrice(pickupDate, returnDate);
        double rentPrice = days * car.getRentalPrice();
        System.out.println("Car rented " + days + " days for " + rentPrice + " euros.");
    }

    public void showUserHistory() {
        UserHistoryService userHistoryService = new UserHistoryService();
        String username = Login.getInstance().getUserSession().getUserName();

        List<UserHistory> userHistories = userHistoryService.getHistoriesOfUser(username);
        if (userHistories == null) {
            System.out.println("We found no entries for username: " + username);
            return;
        }
        System.out.println("Your history: ");
        int recordNr = 1;
        for (UserHistory userHistory : userHistories) {
            System.out.println(recordNr + ": " + userHistory.getDetails());
            recordNr++;
        }
    }

    public void returnRentedCar(String VIN) {
        /*@Todo need to check the period
        * and make another relation between userhistory and carhistory tables
        * or,better, redesign the database
        */
        UserHistoryService userHistoryService = new UserHistoryService();

    }

    public void showCurrentRentedOrReservedCars() {
        CarHistoryService carHistoryService = new CarHistoryService();
        String userID = Login.getInstance().getUserSession().getUserName();

        List<CarHistory> carHistories = carHistoryService.findByColumn("rentedTo_user_id", userID);
        if (carHistories == null) {
            System.out.println("You did not rent/reserve any car!");
            return;
        }
        CarService carService = new CarService();
        for (CarHistory carHistory : carHistories) {
            String rentedReservedVIN = carHistory.getCar().getVIN();
            Car car = carService.findById(new Car(), rentedReservedVIN);

            System.out.println("You have rented/reserved car with VIN: " + rentedReservedVIN
                    + " , brand: " + car.getBrand() + " ,model: " + car.getModel()
                    + " from: " + carHistory.getPickupDate()
                    + " until: " + carHistory.getReturnDate());
        }
    }

    private long calculateRentPrice(LocalDate pickupDate, LocalDate returnDate) {
        return ChronoUnit.DAYS.between(pickupDate, returnDate);
    }

    public boolean checkIfReserved(Car car, LocalDate pickupDate, LocalDate returnDate) {
        CarHistoryService carHistoryService = new CarHistoryService();
        String checkVINifReserved = car.getVIN();

        List<CarHistory> carHistories = carHistoryService.findByColumn("car_id", checkVINifReserved);
        if (carHistories == null) {
            return false;
        }
        for (CarHistory carHistory : carHistories) {
            boolean isReserved = checkIfReserved(carHistory, pickupDate, returnDate);
            if (isReserved) {
                System.out.println("Sorry, this car is reserved for the requested period.");
                return true;
            }
        }
        return false;
    }

    private boolean checkIfReserved(CarHistory carHistory, LocalDate pickupDate, LocalDate returnDate) {
        LocalDate reservedPickUpDate = carHistory.getPickupDate();
        LocalDate reservedReturnDate = carHistory.getReturnDate();
        if (reservedPickUpDate.isEqual(pickupDate) && reservedReturnDate.isEqual(returnDate)) {
            return true;
        }
        if ((pickupDate.isAfter(reservedPickUpDate) && pickupDate.isBefore(reservedReturnDate)) ||
                (returnDate.isAfter(reservedPickUpDate) && returnDate.isBefore(reservedReturnDate))) {
            return true;
        }
        return false;
    }

}

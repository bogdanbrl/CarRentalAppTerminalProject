package ui;

import applicationSession.Login;
import persistence.model.Account;
import persistence.model.Car;
import persistence.model.User;
import services.AccountService;
import services.CarService;
import services.CustomerService;
import services.UserService;
import utils.GregorianDateMatcher;
import utils.encryption.PasswordEncryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 23/03/2021 - 6:53 PM
 * @project CarRentalAppSDAProject
 */
public class CustomerUI {

    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);

    public void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("Press 1 to change password");
        System.out.println("Press 2 to delete account");
        System.out.println("Press 3 to see our cars");
        System.out.println("Press 4 to see your history");
        System.out.println("Press 5 to see your current rented or reserved cars");
        System.out.println("Press 6 to rent a car");
        System.out.println("Press 7 to logout");

        while(!intScanner.hasNextInt()){
            System.out.println("Insert a valid choice");
            intScanner.next();
        }

        int choice = intScanner.nextInt();

        CustomerService customerService = new CustomerService();

        switch (choice){
            case 1:
                String newPassword = readNewPassword();
                customerService.changePassword(newPassword);
                break;
            case 2:
                customerService.deleteAccount();
                break;
            case 3:
                customerService.showAllCars();
                break;
            case 4:
                customerService.showUserHistory();
                break;
            case 5:
                customerService.showCurrentRentedOrReservedCars();
                break;
            case 6:
                Car car = getDesiredCar();
                LocalDate pickupDate = getPickupDate();
                LocalDate returnDate = getReturnDate();
                while (pickupDate.isAfter(returnDate)){
                    System.out.println("Return date cannot be before pickup date");
                    returnDate=getReturnDate();
                }

                boolean isReserved = customerService.checkIfReserved(car, pickupDate, returnDate);
                if(isReserved==false){
                    customerService.rentCar(car, pickupDate, returnDate);
                }

                break;
            case 7: customerService.logout();
                break;
            default: showMenu();
        }
    }

    private LocalDate getReturnDate() {
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

    private LocalDate getPickupDate() {
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

    private Car getDesiredCar() {
        CarService carService = new CarService();

        System.out.println("Insert the VIN of the required car: ");
        String VIN = stringScanner.next();
        Car requiredCar = carService.findById(new Car(), VIN);
        while (requiredCar==null){
            System.out.println("We don't own this car. Insert another VIN");
            VIN = stringScanner.next();
            requiredCar = carService.findById(new Car(), VIN);
        }
        return requiredCar;
    }

    private String readNewPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {

        User currentSessionUser = Login.getInstance().getUserSession();
        AccountService accountService = new AccountService();
        Account currentSessionUserAccount = accountService.findById(new Account(), currentSessionUser.getUserName());
        String passFromDB = currentSessionUserAccount.getPassword();

        System.out.println("Insert your current password");
        String currentPassword = stringScanner.next();
        while (!passFromDB.equals(encryptPassword(currentPassword))){
            System.out.println("Current password is not correct. Insert current password: ");
            currentPassword = stringScanner.next();
        }

        System.out.println("Insert new password: ");
        String newPassword = stringScanner.next();
        System.out.println("Repeat new password: ");
        String repeatPassword = stringScanner.next();
        while (!newPassword.equals(repeatPassword)){
            System.out.println("Password not match.");
            System.out.println("Insert new password: ");
            newPassword = stringScanner.next();
            System.out.println("Repeat new password: ");
            repeatPassword = stringScanner.next();
        }
        return newPassword;
    }

    private String encryptPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.encrypt(password);
    }
}

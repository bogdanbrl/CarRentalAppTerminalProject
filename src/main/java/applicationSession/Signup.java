package applicationSession;

import persistence.model.Account;
import persistence.model.Administrator;
import persistence.model.Customer;
import persistence.model.User;
import services.AccountService;
import services.UserService;
import utils.encryption.PasswordEncryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 22/03/2021 - 8:21 PM
 * @project CarRentalAppTerminalProject
 */
public class Signup {

    private Scanner scanner = new Scanner(System.in);

    private Account createNewAccount() throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = null;

        if(Login.getInstance().getUserSession() == null) {
            user = new Customer();
        }else{
            /** only an admin can create a new admin account */
            user = new Administrator();
        }


        System.out.println("Insert first name: ");
        String firstName = scanner.next();

        System.out.println("Insert last name: ");
        String lastName = scanner.next();

        System.out.println("Insert phone number: ");
        String phoneNumber = scanner.next();

        System.out.println("Insert email: ");
        String email = scanner.next();

        System.out.println("Insert username: ");
        String username = scanner.next();

        UserService userService = new UserService();
        User u = userService.findById(new User(), username);

        boolean isNotAvailable = u != null;
        while(isNotAvailable){
            System.out.println("Username already taken! Insert a new username: ");
            username = scanner.next();
            u = userService.findById(new User(), username);
            isNotAvailable = u != null;
        }

        System.out.println("Insert password: ");
        String password = scanner.next();
        System.out.println("Repeat password: ");
        String repeatedPassword = scanner.next();

        while(!password.equals(repeatedPassword)){
            System.out.println("Password do not matched!\t");
            System.out.println("Insert password: ");
            password = scanner.next();
            System.out.println("Repeat password: ");
            repeatedPassword = scanner.next();
        }


        String encryptedPass = encryptPassword(password);

        Account account = new Account();
        account.setUsername(username);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setPhoneNumber(phoneNumber);
        account.setPassword(encryptedPass);

        return account;
    }

    private String encryptPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.encrypt(password);
    }

    public void signup() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Account customerAccount = createNewAccount();
        User customer = new Customer(customerAccount.getUsername(), customerAccount);

        AccountService accountService = new AccountService();
        UserService userService = new UserService();

        accountService.addAccount(customerAccount);
        userService.addUser(customer);
        customerAccount.setUser(customer);
        accountService.updateAccount(customerAccount);

        if(Login.getInstance().getUserSession() == null){
            System.out.println("Account created! Go back and login!");
        }else{
            System.out.println("New admin account created!");
        }

    }
}

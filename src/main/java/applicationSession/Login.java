package applicationSession;

import persistence.model.Account;
import persistence.model.User;
import services.AccountService;
import services.UserService;
import utils.encryption.PasswordEncryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Double "B"
 * @created 22/03/2021 - 8:21 PM
 * @project CarRentalAppTerminalProject
 */
public class Login {

    private Scanner scanner = new Scanner(System.in);
    private User userSession;

    private Login() {    }

    private static final Login instance = new Login();

    public static Login getInstance(){
        return instance;
    }

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }

    public void login() throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("Insert username");
        String username = scanner.next();
        System.out.println("Insert password");
        String password = scanner.next();

        UserService userService = new UserService();
        User user = userService.findById(new User(), username);

        if(user != null){
            AccountService accountService = new AccountService();
            Account account = accountService.findById(new Account(), username);
            String passwordFromRepository = account.getPassword();
            String encryptedPass = encryptPassword(password);

            int counter = 1;
            while(counter < 3){
                if(encryptedPass.equals(passwordFromRepository)){
                    userSession = user;
                    return;
                }else{
                    System.out.println("Password is incorrect. Insert password: \n");
                    password = scanner.next();
                    encryptedPass = encryptPassword(password);
                    counter++;
                }
            }

            // @Todo need to add extra business logic to block and unblock account
            System.out.println("Your account has been blocked! Reset your password.");
        }else{
            System.out.println("We didn't find this account. Please create one!");
        }
    }

    public void signup() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Signup signup = new Signup();
        signup.signup();
    }

    private String encryptPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.encrypt(password);
    }
}

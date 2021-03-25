import applicationSession.Login;
import persistence.model.Administrator;
import persistence.model.Customer;
import ui.AdministratorUI;
import ui.CustomerUI;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/**
 * @author Bogdan Brl
 * @created 20/03/2021 - 11:23 AM
 * @project CarRentalAppTerminalProject
 */
public class AppManagement {

    private Login loginSession;
    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);

    public Login getLoginSession() {
        return loginSession;
    }

    public void startApp() throws InvalidKeySpecException, NoSuchAlgorithmException {
        loginSession = Login.getInstance();

        String choice = showStartMenu();
        switch (choice){
            case "1" : loginSession.login();
                break;
            case "2" : loginSession.signup();
                break;
            case "3" : System.exit(0);
                break;
            default:
                System.out.println("This option doesn't exist!");

        }

    }

    private String showStartMenu(){
        System.out.println("Insert: \n 1 - to login \n 2 - to sign up \n 3 - to exit" );
        String choose = stringScanner.next();

        while (!(choose.equals("1") || choose.equals("2") || choose.equals("3"))){
            System.out.println("Insert a valid option!");
            choose = stringScanner.next();
        }

        return choose;
    }

    public void showMenu() throws InvalidKeySpecException, NoSuchAlgorithmException {
        if(loginSession.getUserSession() instanceof Administrator){
            AdministratorUI administratorUI = new AdministratorUI();
            administratorUI.showMenu();
        }else if(loginSession.getUserSession() instanceof Customer){
            CustomerUI customerUI = new CustomerUI();
            customerUI.showMenu();
        }
    }
}

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author Bogdan Brl
 * @created 20/03/2021 - 11:22 AM
 * @project CarRentalAppSDAProject
 */
public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {

        AppManagement appManagement = new AppManagement();
        appManagement.startApp();

        while (appManagement.getLoginSession().getUserSession() != null) {
            appManagement.showMenu();
            while (appManagement.getLoginSession().getUserSession() == null) {
                appManagement.startApp();
            }
        }

    }

}

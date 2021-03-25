package utils.encryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author Double "B"
 * @created 25/03/2021 - 4:03 PM
 * @project CarRentalAppSDAProject
 */
public class Main {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        String pass = "passeord";
        System.out.println("current password: " + pass);

        String hashedPass = passwordEncryption.encrypt(pass);
        System.out.println("Hashed password: " + hashedPass);

        System.out.println(hashedPass.equals("47656ac4717134d6c219c297ef9a9d92c20cd8148e1061b04f9e9da1652fba855c1ed816874b0748df5396159603b66896038ffdae6420ec2ce843a1b17de33f"));
        System.out.println("47656ac4717134d6c219c297ef9a9d92c20cd8148e1061b04f9e9da1652fba855c1ed816874b0748df5396159603b66896038ffdae6420ec2ce843a1b17de33f".length());

    }
}

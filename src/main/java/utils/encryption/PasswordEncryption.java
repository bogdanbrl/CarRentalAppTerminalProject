package utils.encryption;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author Double "B"
 * @created 25/03/2021 - 3:50 PM
 * @project CarRentalAppTerminalProject
 */
public class PasswordEncryption {

    /** BASIC!!!! encryption with PBKDF2*/

    private String salt = "1234";
    private final int iterations = 10000;
    private final int keyLength = 512;

    public String encrypt(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        char[] passwordChar = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        byte[] hashedBytes = hashPassword(passwordChar, saltBytes, iterations, keyLength);
        String hashedString = Hex.encodeHexString(hashedBytes);

        return hashedString;
    }

    private byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        SecretKey key = factory.generateSecret(spec);
        byte[] res = key.getEncoded();
        return res;
    }
}

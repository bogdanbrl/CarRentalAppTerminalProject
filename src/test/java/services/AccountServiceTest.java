package services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.dao.GenericDao;
import persistence.model.Account;
import persistence.model.Administrator;
import persistence.model.Customer;
import persistence.model.User;
import utils.encryption.PasswordEncryption;

import javax.persistence.Entity;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bogdan Brl
 * @created 21/03/2021 - 12:30 PM
 * @project CarRentalAppSDAProject
 */

class AccountServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAccount() throws InvalidKeySpecException, NoSuchAlgorithmException {
        AccountService accountService = new AccountService();
        UserService userService = new UserService();

        Account admin = new Account("admin", "admin", "admin", "546546", "admin@email.com", encryptPassword("admin"));
        User administrator = new Administrator(admin.getUsername(), admin);
        accountService.addAccount(admin);
        userService.addUser(administrator);
        admin.setUser(administrator);
        accountService.updateAccount(admin);


        Account customer = new Account("user", "user", "user", "9531356", "user@email.com", encryptPassword("user"));
        User user = new Customer(customer.getUsername(), customer);
        accountService.addAccount(customer);
        userService.addUser(user);
        customer.setUser(user);
        accountService.updateAccount(customer);
    }

    private String encryptPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PasswordEncryption passwordEncryption = new PasswordEncryption();
        return passwordEncryption.encrypt(password);
    }

    @Test
    void viewAccounts() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void findById() {
    }
}
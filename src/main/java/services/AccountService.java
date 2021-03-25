package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.Account;

import java.util.List;

/**
 * @author Bogdan Brl
 * @created 21/03/2021 - 12:10 PM
 * @project CarRentalAppTerminalProject
 */
public class AccountService {

    SessionFactory sessionFactory;
    private GenericDao<Account> accountGenericDao = new GenericDao<>();

    public void addAccount(Account account) {
        accountGenericDao.add(account);
    }

    public List<Account> viewAccounts(Account account) {
        List<Account> accountList = accountGenericDao.getAll(account);
        return accountList;
    }

    public void deleteAccount(Account account) {
        accountGenericDao.delete(account);
    }

    public void updateAccount(Account account) {
        accountGenericDao.update(account);
    }

    public Account findById(Account account, String id) {
        Account account1 = accountGenericDao.findById(account, id);
        return account1;
    }


}

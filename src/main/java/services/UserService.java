package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.Account;
import persistence.model.User;

import java.util.List;

/**
 * @author Bogdan Brl
 * @created 21/03/2021 - 12:10 PM
 * @project CarRentalAppTerminalProject
 */
public class UserService {

    SessionFactory sessionFactory;
    private GenericDao<User> userGenericDao = new GenericDao<>();

    public void addUser(User user) {
        userGenericDao.add(user);
    }

    public List<User> viewUsers(User user) {
        List<User> userList = userGenericDao.getAll(user);
        return userList;
    }

    public void deleteUser(User user) {
        userGenericDao.delete(user);
    }

    public void updateUser(User user) {
        userGenericDao.update(user);
    }

    public User findById(User user, String id) {
        User account1 = userGenericDao.findById(user, id);
        return account1;
    }

    public List<User> showAllUsers(){
        List<User> users = userGenericDao.getAll(new User());
        return users;
    }


}

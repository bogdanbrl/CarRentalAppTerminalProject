package services;

import org.hibernate.SessionFactory;
import persistence.dao.GenericDao;
import persistence.model.UserHistory;

import java.util.List;

/**
 * @author Bogdan Brl
 * @created 21/03/2021 - 12:10 PM
 * @project CarRentalAppSDAProject
 */
public class UserHistoryService {

    SessionFactory sessionFactory;
    private GenericDao<UserHistory> userHistoryGenericDao = new GenericDao<>();

    public void addUserHistory(UserHistory userHistory) {
        userHistoryGenericDao.add(userHistory);
    }

    public List<UserHistory> viewUsers(UserHistory userHistory) {
        List<UserHistory> userHistoryList = userHistoryGenericDao.getAll(userHistory);
        return userHistoryList;
    }

    public List<UserHistory> getHistoriesOfUser(String username){
        List<UserHistory> userHistories = userHistoryGenericDao.findByColumn(new UserHistory(), "user_id", username);
        return userHistories;
    }

    public void deleteUserHistory(UserHistory userHistory) {
        userHistoryGenericDao.delete(userHistory);
    }

    public void updateUserHistory(UserHistory userHistory) {
        userHistoryGenericDao.update(userHistory);
    }

    public UserHistory findById(UserHistory userHistory, String id) {
        UserHistory userHistory1 = userHistoryGenericDao.findById(userHistory, id);
        return userHistory1;
    }
}

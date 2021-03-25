package services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.model.User;
import persistence.model.UserHistory;

/**
 * @author Bogdan Brl
 * @created 22/03/2021 - 2:38 PM
 * @project CarRentalAppTerminalProject
 */
class UserHistoryServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addUserHistory() {
        UserHistoryService userHistoryService = new UserHistoryService();
        UserService userService = new UserService();

        UserHistory userHistory = new UserHistory();
        String userHistoryDetails = "bogdan added andrei";

        String id = "admin";

        User user = userService.findById(new User(), id);
        if(user !=  null){
            userHistory.setUser(user);
            userHistory.setDetails(userHistoryDetails);
            userHistoryService.addUserHistory(userHistory);
        }else{
            System.out.println("Record with id: " + id + " not found!");
        }

    }
}
package persistence.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Bogdan Brl
 * @created 22/03/2021 - 2:01 PM
 * @project CarRentalAppTerminalProject
 */

@NoArgsConstructor
@Entity
public class Administrator extends User{

    public Administrator(String userName, Account account) {
        super(userName, account);
        super.setAccountType("administrator");
    }

    @Override
    public String toString() {
        return "Administrator: " + super.toString();
    }
}

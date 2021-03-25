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
public class Customer extends User{

    public Customer(String userName, Account account) {
        super(userName, account);
        super.setAccountType("customer");
    }

    @Override
    public String toString() {
        return "Customer: " + super.toString();
    }
}

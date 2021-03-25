package persistence.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Bogdan Brl
 * @created 20/03/2021 - 12:41 PM
 * @project CarRentalAppTerminalProject
 */

@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
@Entity
public class User {

    public User(String userName, Account account) {
        this.userName = userName;
        this.account = account;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String userName;

    @OneToOne(mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull
    private Account account;

    @EqualsAndHashCode.Exclude
    @Column(name = "account_type", nullable = false)
    private String accountType;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user")
    private List<UserHistory> userHistoryList;
}

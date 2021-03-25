package persistence.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Account")
@Entity
public class Account {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String username;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "date_of_sign_up", nullable = false)
    private LocalDate dateOfSignup;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @EqualsAndHashCode.Exclude
    @Column(name = "email", nullable = false)
    private String email;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "password", nullable = false)
    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Account() {
        this.dateOfSignup = LocalDate.now();
    }

    public Account(String username, String firstName, String lastName, String phoneNumber, String email, String password) {
        this.username = username;
        this.dateOfSignup = LocalDate.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

}

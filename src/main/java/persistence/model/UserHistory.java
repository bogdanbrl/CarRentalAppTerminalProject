package persistence.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Bogdan Brl
 * @created 20/03/2021 - 12:43 PM
 * @project CarRentalAppSDAProject
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserHistory")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @EqualsAndHashCode.Exclude
    @Column(name = "details")
    private String details;

    @EqualsAndHashCode.Exclude
    @Column(name = "currentRentedCar")
    private String currentRentedCar;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
}

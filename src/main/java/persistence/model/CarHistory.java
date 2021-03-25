package persistence.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Double "B"
 * @created 22/03/2021 - 7:02 PM
 * @project CarRentalAppTerminalProject
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "CarHistory")
public class CarHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    private Car car;

    @EqualsAndHashCode.Exclude
    @Column(name = "rentedTo_user_id",nullable = false)
    private String rentedToUser;

    @EqualsAndHashCode.Exclude
    @Column(name = "pickupDate", nullable = false)
    private LocalDate pickupDate;

    @EqualsAndHashCode.Exclude
    @Column(name = "returnDate", nullable = false)
    private LocalDate returnDate;

    @EqualsAndHashCode.Exclude
    @Column(name = "rentPricePerDay", nullable = false)
    private double rentPricePerDay;
}

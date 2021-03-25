package persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Double "B"
 * @created 22/03/2021 - 4:15 PM
 * @project CarRentalAppTerminalProject
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "CarOptions")
public class CarOptions {

    public CarOptions(boolean automaticGearBox, boolean hasNavigation, boolean hasHeatedSeats) {
        this.automaticGearBox = automaticGearBox;
        this.hasNavigation = hasNavigation;
        this.hasHeatedSeats = hasHeatedSeats;
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "carOptions")
    private List<Car> carList;

    @EqualsAndHashCode.Exclude
    @Column(name = "automaticGearBox", nullable = false)
    private boolean automaticGearBox;

    @EqualsAndHashCode.Exclude
    @Column(name = "hasNavigation", nullable = false)
    private boolean hasNavigation;

    @EqualsAndHashCode.Exclude
    @Column(name = "hasHeatedSeats", nullable = false)
    private boolean hasHeatedSeats;
}

package persistence.model;

import lombok.*;
import persistence.model.enums.CarClass;
import persistence.model.enums.CarType;
import persistence.model.enums.EngineType;

import javax.persistence.*;
import java.util.List;

/**
 * @author Double "B"
 * @created 22/03/2021 - 4:11 PM
 * @project CarRentalAppTerminalProject
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Car")
public class Car {

    public Car(String VIN, String brand, String model, int yearOfProduction, CarType carType, CarClass carClass, EngineType engineType, double rentalPrice, boolean isAvailable) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.carType = carType;
        this.carClass = carClass;
        this.engineType = engineType;
        this.rentalPrice = rentalPrice;
        this.isAvailable = isAvailable;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String VIN;

    @EqualsAndHashCode.Exclude
    @Column(name = "brand", nullable = false)
    private String brand;

    @EqualsAndHashCode.Exclude
    @Column(name = "model", nullable = false)
    private String model;

    @EqualsAndHashCode.Exclude
    @Column(name = "yearOfProduction", nullable = false)
    private int yearOfProduction;

    @EqualsAndHashCode.Exclude
    @Column(name = "carType", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @EqualsAndHashCode.Exclude
    @Column(name = "carClass", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarClass carClass;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carOptions", referencedColumnName = "id")
    private CarOptions carOptions;

    @EqualsAndHashCode.Exclude
    @Column(name = "engineType", nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @EqualsAndHashCode.Exclude
    @Column(name = "rentalPrice", nullable = false)
    private double rentalPrice;

    @EqualsAndHashCode.Exclude
    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "car")
    private List<CarHistory> carHistories;

}

package persistence.model.enums;

/**
 * @author Double "B"
 * @created 22/03/2021 - 4:14 PM
 * @project CarRentalAppSDAProject
 */
public enum CarType {

    SEDAN("SDN"),
    COUPE("COU"),
    SPORTS_CAR("SPT"),
    STATION_WAGON("WAG"),
    HATCHBACK("HAT"),
    CONVERTIBLE("CNV"),
    SPORT_UTILITY_VEHICLE("SUV"),
    MINIVAN("MVN"),
    PICKUP("PCK");

    private String shortName;

    CarType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static CarType fromShortName(String shortName){
        switch (shortName){
            case "SDN": return CarType.SEDAN;
            case "COU": return CarType.COUPE;
            case "SPT": return CarType.SPORTS_CAR;
            case "WAG": return CarType.STATION_WAGON;
            case "HAT": return CarType.HATCHBACK;
            case "CNV": return CarType.CONVERTIBLE;
            case "SUV": return CarType.SPORT_UTILITY_VEHICLE;
            case "MVN": return CarType.MINIVAN;
            case "PCK": return CarType.PICKUP;
            default: throw new IllegalArgumentException("Car type ["+shortName+"] not supported.");
        }
    }
}

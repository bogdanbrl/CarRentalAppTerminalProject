package persistence.model.enums;

/**
 * @author Double "B"
 * @created 22/03/2021 - 4:15 PM
 * @project CarRentalAppSDAProject
 */
public enum CarClass {
    ECONOMY("E"),
    MEDIUM("M"),
    LUXURY("L");

    private String shortName;

    CarClass(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static CarClass fromShortName(String shortName){
        switch (shortName){
            case "E": return CarClass.ECONOMY;
            case "M": return CarClass.MEDIUM;
            case "L": return CarClass.LUXURY;
            default: throw new IllegalArgumentException("Car class ["+shortName+"] not supported.");
        }
    }
}

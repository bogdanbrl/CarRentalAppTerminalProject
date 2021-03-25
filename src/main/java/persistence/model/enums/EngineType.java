package persistence.model.enums;

/**
 * @author Double "B"
 * @created 22/03/2021 - 4:16 PM
 * @project CarRentalAppTerminalProject
 */
public enum EngineType {

    GASOLINE("G"),
    DIESEL("D"),
    HYBRID("H"),
    ELECTRIC("E");

    private String shortName;

    private EngineType(String shortName){
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static EngineType fromShortName(String shortName){
        switch (shortName){
            case "G": return EngineType.GASOLINE;
            case "D": return EngineType.DIESEL;
            case "H": return EngineType.HYBRID;
            case "E": return EngineType.ELECTRIC;
            default: throw new IllegalArgumentException("Engine type ["+shortName+"] not supported.");
        }
    }

}

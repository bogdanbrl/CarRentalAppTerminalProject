package persistence.model.enums;

/**
 * @author Double "B"
 * @created 23/03/2021 - 7:30 PM
 * @project CarRentalAppTerminalProject
 */
public class CheckEnums {

    public static CarType searchForCarType(String str){
        for (CarType carType : CarType.values()) {
            if(carType.name().equalsIgnoreCase(str)){
                return carType;
            }
        }
        return null;
    }

    public static CarClass searchForCarClass(String str){
        for (CarClass carClass : CarClass.values()) {
            if(carClass.name().equalsIgnoreCase(str)){
                return carClass;
            }
        }
        return null;
    }

    public static EngineType searchForEngineType(String str){
        for (EngineType engineType : EngineType.values()) {
            if(engineType.name().equalsIgnoreCase(str)){
                return engineType;
            }
        }
        return null;
    }
}

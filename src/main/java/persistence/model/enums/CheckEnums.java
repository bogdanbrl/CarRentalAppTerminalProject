package persistence.model.enums;

/**
 * @author Double "B"
 * @created 23/03/2021 - 7:30 PM
 * @project CarRentalAppTerminalProject
 */
public class CheckEnums {

    public static CarType searchForCarType(String str){
        for (CarType carType : CarType.values()) {
            if(carType.name().equals(str.toUpperCase())){
                return carType;
            }
        }
        return null;
    }

    public static CarClass searchForCarClass(String str){
        for (CarClass carClass : CarClass.values()) {
            if(carClass.name().equals(str.toUpperCase())){
                return carClass;
            }
        }
        return null;
    }

    public static EngineType searchForEngineType(String str){
        for (EngineType engineType : EngineType.values()) {
            if(engineType.name().equals(str.toUpperCase())){
                return engineType;
            }
        }
        return null;
    }
}

package persistence.model.convertors;

import persistence.model.enums.CarClass;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Double "B"
 * @created 22/03/2021 - 5:18 PM
 * @project CarRentalAppSDAProject
 */

@Converter(autoApply = true)
public class CarClassConvertor implements AttributeConverter<CarClass, String> {
    @Override
    public String convertToDatabaseColumn(CarClass carClass) {
        return carClass.getShortName();
    }

    @Override
    public CarClass convertToEntityAttribute(String dbDataValue) {
        return CarClass.fromShortName(dbDataValue);
    }
}

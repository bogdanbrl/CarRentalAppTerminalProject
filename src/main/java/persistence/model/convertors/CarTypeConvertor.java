package persistence.model.convertors;

import persistence.model.enums.CarType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Double "B"
 * @created 22/03/2021 - 5:27 PM
 * @project CarRentalAppSDAProject
 */

@Converter(autoApply = true)
public class CarTypeConvertor implements AttributeConverter<CarType, String> {

    @Override
    public String convertToDatabaseColumn(CarType carType) {
        return carType.getShortName();
    }

    @Override
    public CarType convertToEntityAttribute(String dbDataValue) {
        return CarType.fromShortName(dbDataValue);
    }
}

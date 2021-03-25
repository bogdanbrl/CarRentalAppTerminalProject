package persistence.model.convertors;

import persistence.model.enums.EngineType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Double "B"
 * @created 22/03/2021 - 5:12 PM
 * @project CarRentalAppSDAProject
 */

@Converter(autoApply = true)
public class EngineTypeConvertor implements AttributeConverter<EngineType, String> {
    @Override
    public String convertToDatabaseColumn(EngineType engineType) {
        return engineType.getShortName();
    }

    @Override
    public EngineType convertToEntityAttribute(String dbDataValue) {
        return EngineType.fromShortName(dbDataValue);
    }
}

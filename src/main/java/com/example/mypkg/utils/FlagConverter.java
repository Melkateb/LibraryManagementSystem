/**
 * 
 */
package com.example.mypkg.utils;

import javax.persistence.AttributeConverter;

/**
 * @author MRKAT
 *
 */
public class FlagConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null)
			return null;

		if (attribute == true) {
			return "Y";
		} else {
			return "N";
		}
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}

		if (dbData.equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

}

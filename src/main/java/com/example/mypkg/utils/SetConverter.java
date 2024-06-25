/**
 * 
 */
package com.example.mypkg.utils;

import java.util.Set;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author MRKAT
 *
 */
public class SetConverter implements AttributeConverter<Set<String>, String> {

	@Override
	public String convertToDatabaseColumn(Set<String> attribute) {
		if (attribute == null) {
			return null;
		}

		try {
			return new ObjectMapper().writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public Set<String> convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		try {
			return new ObjectMapper().readValue(dbData, Set.class);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
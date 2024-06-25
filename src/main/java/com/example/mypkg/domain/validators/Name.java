/**
 * 
 */
package com.example.mypkg.domain.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;;

/**
 * @author MRKAT
 *
 */
@Size(min = 1, max = 200)
@Target({ FIELD, PARAMETER, LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Name {

	String message()

	default "Invalid name, name should have a length between 1 and 200 characters.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

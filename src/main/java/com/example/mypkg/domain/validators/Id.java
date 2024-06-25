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
import javax.validation.constraints.Size;

/**
 * @author MRKAT
 *
 */
@Size(min = 1, max = 36)
@Target({ FIELD, PARAMETER, LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Id {

	String message()

	default "Invalid Id";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

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
import javax.validation.constraints.Pattern;

/**
 * @author MRKAT
 *
 */
@Pattern(regexp = "^(?:00971|\\+971|0)?(?:50|51|52|55|56|58|2|3|4|6|7|9)\\d{7}$")
@Target({ FIELD, PARAMETER, LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Mobile {

	String message()

	default "Invalid mobile number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

package org.primefaces.test.crud.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullAndBlankValidation.class)
public @interface NotNullAndBlank {
	
	String message() default "{javax.validation.constraints.NotNull.message}";
    
	Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
package org.primefaces.test.crud.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullAndBlankValidation implements ConstraintValidator<NotNullAndBlank, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !value.trim().isEmpty();
	}
}
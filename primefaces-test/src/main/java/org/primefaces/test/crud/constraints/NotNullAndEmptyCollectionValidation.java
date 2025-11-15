package org.primefaces.test.crud.constraints;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullAndEmptyCollectionValidation implements ConstraintValidator<NotNullAndEmpty, Collection<?>> {
	
	@Override
	public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
		return value != null && !value.isEmpty();
	}
}
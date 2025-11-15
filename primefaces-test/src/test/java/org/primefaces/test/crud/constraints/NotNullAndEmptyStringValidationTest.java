package org.primefaces.test.crud.constraints;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NotNullAndEmptyStringValidationTest {
	
	private NotNullAndEmptyStringValidation validation;
	
	@BeforeEach
	void setUp() {
		validation = new NotNullAndEmptyStringValidation();
	}
	
	@Nested
	class Valid {
		
		private ConstraintValidatorContext context;
		
		@ParameterizedTest(name = "Value: ''{0}''.")
		@NullAndEmptySource
		@ValueSource(strings = { " " })
		void semValor(String value) {
			assertFalse(validation.isValid(value, context));
		}
		
		@ParameterizedTest(name = "Value: ''{0}''.")
		@ValueSource(strings = { "value" })
		void aceito(String value) {
			assertTrue(validation.isValid(value, context));
		}
	}
}
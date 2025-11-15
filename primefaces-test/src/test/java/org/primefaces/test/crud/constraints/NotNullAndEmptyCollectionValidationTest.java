package org.primefaces.test.crud.constraints;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

class NotNullAndEmptyCollectionValidationTest {
	
	private NotNullAndEmptyCollectionValidation validation;
	
	@BeforeEach
	void setUp() {
		validation = new NotNullAndEmptyCollectionValidation();
	}
	
	@Nested
	class Valid {
		
		private ConstraintValidatorContext context;
		
		@ParameterizedTest(name = "Coleção: ''{0}''.")
		@NullSource
		void semColecao(Collection<?> collection) {
			assertFalse(validation.isValid(collection, context));
		}
		
		@ParameterizedTest(name = "Lista: ''{0}''.")
		@NullAndEmptySource
		void semLista(List<?> lista) {
			assertFalse(validation.isValid(lista, context));
		}
		
		@Test
		void aceito() {
			List<?> lista = Arrays.asList("test");
			assertTrue(validation.isValid(lista, context));
		}
	}
}
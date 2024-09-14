package org.primefaces.test.crud.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;

import lombok.Data;

public class ValidatorHelper {
	
	private static final Validator validator;
	
	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	public static <T> RetornoValidacao validar(T entity) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity);
		
		if (violations == null || violations.isEmpty()) {
			return new RetornoValidacao(Resultado.ACEITO);
		}
		
		return new RetornoValidacao(Resultado.REPROVADO, violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()));
	}
	
	@Data
	public static class RetornoValidacao {
		
		private Resultado resultado;
		private List<String> mensagens;
		
		public RetornoValidacao(Resultado resultado) {
			this.resultado = resultado;
		}
		
		public RetornoValidacao(Resultado resultado, List<String> mensagens) {
			this.resultado = resultado;
			this.mensagens = mensagens;
		}
	}
}
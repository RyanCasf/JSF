package org.primefaces.test.datatable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EntidadeKaiBuilder {
	
	private static final int NUM_REGISTROS = 200;
	private static final String[] PAISES = {"Brasil", "EUA", "Canadá", "Alemanha", "Japão", "Austrália", "Índia", "China"};
	private static final String[] AGENTES = {"Agente A", "Agente B", "Agente C", "Agente D", "Agente E"};
	private static final StatusKai[] STATUS = StatusKai.values();
	
	public static List<EntidadeKai> getAll() {
		List<EntidadeKai> listaKai = new ArrayList<>();
		
		for (int i = 1; i <= NUM_REGISTROS; i++) {
			String nome = "Pessoa " + i + " Sobrenome";
			String pais = PAISES[i % PAISES.length];
			String agente = AGENTES[i % AGENTES.length];
			StatusKai status = STATUS[i % STATUS.length];
			BigDecimal salario = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(30000.00D, 150000.00D));
			
			long dataBase = 1672531200000L;
			long variacaoData = (long) i * 86400000L;
			Date data = new Date(dataBase + variacaoData);
			
			listaKai.add(EntidadeKai.builder()
					.nome(nome)
					.pais(pais)
					.agente(agente)
					.data(data)
					.salario(salario)
					.status(status)
					.build()
			);
		}
		
		return listaKai;
	}
}
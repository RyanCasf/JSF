package org.primefaces.test.datatable;

import org.primefaces.test.badge.BadgeColor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusKai {
	
	NEW("New", BadgeColor.BLUE),
	RENEWAL("Renewal", BadgeColor.BLUE),
	QUALIFIED("Qualified", BadgeColor.GREEN),
	NEGOTIATION("Negotiation", BadgeColor.YELLOW),
	UNQUALIFIED("Unqualified", BadgeColor.RED);
	
	private final String descricao;
	private final BadgeColor cor;
}
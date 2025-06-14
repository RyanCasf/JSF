package org.primefaces.test.tabela;

public enum BloqueioColuna {
	
	BLOQUEADO("Desbloquear", "ui-icon-unlocked", 1),
	DESBLOQUEADO("Bloquear", "ui-icon-locked", 0);
	
	private final String value;
	private final String icon;
	private final int frozenColumns;
	
	private BloqueioColuna(String value, String icon, int frozenColumns) {
		this.value = value;
		this.icon = icon;
		this.frozenColumns = frozenColumns;
	}
	
	public BloqueioColuna toggle() {
        return this == BLOQUEADO ? DESBLOQUEADO : BLOQUEADO;
    }
	
	public String getValue() {
		return value;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public int getFrozenColumns() {
		return frozenColumns;
	}
}
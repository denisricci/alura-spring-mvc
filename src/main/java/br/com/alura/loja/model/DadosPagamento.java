package br.com.alura.loja.model;

import java.math.BigDecimal;

public class DadosPagamento {
	
	private BigDecimal value;

	public DadosPagamento(BigDecimal value) {
		super();
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}

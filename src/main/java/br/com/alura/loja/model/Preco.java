package br.com.alura.loja.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

import br.com.alura.loja.enums.TipoPreco;

@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo;
	
	public BigDecimal getValor() {
		return valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
}

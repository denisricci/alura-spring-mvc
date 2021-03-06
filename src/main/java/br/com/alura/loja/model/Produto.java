package br.com.alura.loja.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.alura.loja.enums.TipoPreco;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descricao;
	private int paginas;
	// Nao sera mais necesario utilizar essa anotacao pois existe uma
	// configuracao Default em AppWebConfiguration.class
	// @DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataLancamento;

	private String sumarioPath;

	@ElementCollection
	List<Preco> precos;

	public Produto(String titulo, String descricao, int paginas) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.paginas = paginas;
	}

	public BigDecimal precoPara(TipoPreco tipoPreco) {
		return this.precos.stream().filter(preco -> preco.getTipo().equals(tipoPreco)).findFirst().get().getValor();
	}

	public Produto() {
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getSumarioPath() {
		return sumarioPath;
	}

	public void setSumarioPath(String sumarioPath) {
		this.sumarioPath = sumarioPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

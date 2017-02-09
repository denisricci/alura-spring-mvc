package br.com.alura.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;	
	private String titulo;
	private String descricao;
	private int paginas;		
	
	public Produto(String titulo, String descricao, int paginas) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.paginas = paginas;
	}
	
	public Produto(){}
	
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
}
